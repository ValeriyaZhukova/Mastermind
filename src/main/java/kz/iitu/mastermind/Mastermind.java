package kz.iitu.mastermind;

import kz.iitu.mastermind.dao.JdbcTemplateGameDaoImpl;
import kz.iitu.mastermind.dao.JdbcTemplatePlayerDaoImpl;
import kz.iitu.mastermind.service.MastermindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Scanner;

@Component
public class Mastermind {

    int userInput;
    int id;
    String username;
    String guess;

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplateGameDaoImpl gameDao;
    @Autowired
    private JdbcTemplatePlayerDaoImpl playerDao;
    @Autowired
    private MastermindService mastermindService;

    private void register(int id, String username)
    {
        playerDao.addNewPlayer(id, username);
    }

    private void login(String username)
    {
        mastermindService.setPlayer(playerDao.getPlayerByUsername(username));
    }

    public void play()
    {
        gameDao.setDataSource(dataSource);
        playerDao.setDataSource(dataSource);

        System.out.println("0: Quit");
        System.out.println("1: Register a new player");
        System.out.println("2: Login");
        System.out.println("3: Play");

        userInput = 1;

        while (userInput != 0)
        {
            userInput = scanner.nextInt();
            switch (userInput) {
                case 0:
                    break;

                case 1: {
                    System.out.println("Enter player id");
                    id = scanner.nextInt();
                    System.out.println("Enter nickname");
                    username = scanner.next();
                    register(id, username);
                    break;
                }

                case 2: {
                    System.out.println("Enter nickname");
                    username = scanner.next();
                    login(username);
                    break;
                }

                case 3: {
                    mastermindService.generateSecretCode();
                    while (!mastermindService.getGame().isWin()) {
                        System.out.println("Enter your guess");
                        guess = scanner.next();
                        mastermindService.setCurrentGuess(guess);
                        mastermindService.makeGuess(guess);
                        mastermindService.evaluateGuess(mastermindService.getCurrentGuess());
                    }
                    break;
                }
            }
        }
    }


}
