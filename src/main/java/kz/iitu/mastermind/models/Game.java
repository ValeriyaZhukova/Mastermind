package kz.iitu.mastermind.models;

public class Game {

    private int id;
    private int secretNumber;
    private int numberOfGuesses;
    private boolean win;
    private int playerID;
    private Player player;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSecretNumber()
    {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber)
    {
        this.secretNumber = secretNumber;
    }

    public int getNumberOfGuesses()
    {
        return numberOfGuesses;
    }

    public void setNumberOfGuesses(int numberOfGuesses)
    {
        this.numberOfGuesses = numberOfGuesses;
    }

    public boolean isWin()
    {
        return win;
    }

    public void setWin(boolean win)
    {
        this.win = win;
    }

    public int getPlayerID()
    {
        return playerID;
    }

    public void setPlayerID(int playerID)
    {
        this.playerID = playerID;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", secretNumber=" + secretNumber +
                ", numberOfGuesses=" + numberOfGuesses +
                ", win=" + win +
                ", player=" + player.getUsername() +
                '}';
    }
}
