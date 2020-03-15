package kz.iitu.mastermind.models;

public class Player {

    private int id;
    private String username;
    private int won;
    private int lost;

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getWon()
    {
        return won;
    }

    public void setWon(int won)
    {
        this.won = won;
    }

    public int getLost()
    {
        return lost;
    }

    public void setLost(int lost)
    {
        this.lost = lost;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", won=" + won +
                ", lost=" + lost +
                '}';
    }
}
