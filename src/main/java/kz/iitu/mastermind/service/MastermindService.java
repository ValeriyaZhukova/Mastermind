package kz.iitu.mastermind.service;

import kz.iitu.mastermind.models.Game;
import kz.iitu.mastermind.models.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MastermindService {

    private Game game = new Game();
    private Player player;
    private List<Integer> secretCode = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> currentGuess = new ArrayList<>();
    private List<Character> result = new ArrayList<>();
    int numberOfGuesses = 0;

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public List<Integer> getSecretCode()
    {
        return secretCode;
    }

    public void setSecretCode(List<Integer> secretCode)
    {
        this.secretCode = secretCode;
    }

    public List<Integer> getCurrentGuess()
    {
        return currentGuess;
    }

    public void setCurrentGuess(List<Integer> currentGuess) {
        this.currentGuess = currentGuess;
    }

    public void setCurrentGuess(String guess) {
        List<Integer> newGuess = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            newGuess.add(Character.getNumericValue((int)(guess.charAt(i))));
        }
        this.currentGuess = newGuess;
    }

    public List<Character> getResult() {
        return result;
    }

    public void setResult(List<Character> result) {
        this.result = result;
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
            }

            else if (currentGuess.get(i) == secretCode.get((i + 1) % 4))
            {
                result.add('b');
            }

            else if (currentGuess.get(i) == secretCode.get((i + 2) % 4))
            {
                result.add('b');
            }

            else if (currentGuess.get(i) == secretCode.get((i + 3) % 4))
            {
                result.add('b');
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


}
