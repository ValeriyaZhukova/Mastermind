package kz.iitu.mastermind.dao;

import kz.iitu.mastermind.models.Game;

import javax.sql.DataSource;
import java.util.List;

public interface GameDao {

    public void setDataSource(DataSource dataSource);

    public void addNewGameRecord(int id, int secretNumber, int numberOfGuesses, boolean win, int playerID);

    public List listGamesByPlayerID(int playerID);

    public List listAllGames();

    public void updateGame(int id, int secretNumber, int numberOfGuesses, boolean win, int playerID);

}
