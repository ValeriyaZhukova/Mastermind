package kz.iitu.mastermind.service;

import kz.iitu.mastermind.model.Game;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MastermindService {

    private Game game = new Game();
    private User user;
    private List<Integer> secretCode = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> currentGuess = new ArrayList<>();
    private List<Character> result = new ArrayList<>();
    int score = 0;
    int numberOfGuesses = 0;

    @Autowired
    GameRepository gameRepository;


    public Game getGame()
    {
        return game;
    }

    public List<Integer> getCurrentGuess()
    {
        return currentGuess;
    }
    public void setCurrentGuess(String guess) {
        List<Integer> newGuess = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            newGuess.add(Character.getNumericValue((int)(guess.charAt(i))));
        }
        this.currentGuess = newGuess;
    }

    public void generateSecretCode()
    {
        for (int i = 0; i < 6; i++)
        {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);

        for (int j = 0; j < 4; j++)
        {
            secretCode.add(numbers.get(j));
            System.out.print(secretCode.get(j));
        }
    }

    public void makeGuess(String guess)
    {
        for (int i = 0; i < 4; i++)
        {
            currentGuess.add(Character.getNumericValue((int)(guess.charAt(i))));
        }
    }

    public void evaluateGuess(List<Integer> currentGuess)
    {
        String stringResult = "";
        for (int i = 0; i < 4; i++)
        {
            if(currentGuess.get(i) == secretCode.get(i))
            {
                result.add('w');
                score += 250;
            }

            else if (currentGuess.get(i) == secretCode.get((i + 1) % 4) || currentGuess.get(i) == secretCode.get((i + 2) % 4) || currentGuess.get(i) == secretCode.get((i + 3) % 4))
            {
                result.add('b');
                score += 100;
            }

            else
            {
                result.add('-');
            }
        }

        numberOfGuesses++;

        for (int i = 0; i < 4; i++)
        {
            stringResult += result.get(i);
        }

        System.out.println("\n"+stringResult);

        if (stringResult == "wwww")
        {
            game.setWin(true);
            System.out.println("Congratulations, you won!");
        }

        else
        {
            System.out.println("Try again!");
        }
    }

    public void setGameAttributes(User user)
    {
        score = score / numberOfGuesses;

        int secretNumber;
        String secretNumberStr = "";

        for (int i = 0; i < secretCode.size(); i++)
        {
            secretNumberStr += secretCode.get(i).toString();
        }

        secretNumber = Integer.parseInt(secretNumberStr);

        game.setSecretNumber(secretNumber);
        game.setNumberOfGuesses(numberOfGuesses);
        game.setScore(score);
        game.setUser(user);

        gameRepository.saveAndFlush(game);
    }



}
