package kz.iitu.mastermind.dao;

import kz.iitu.mastermind.models.Player;

import javax.sql.DataSource;
import java.util.List;

public interface PlayerDao {

    public void setDataSource(DataSource dataSource);

    public void addNewPlayer(int id, String username);

    public Player getPlayerByUsername(String username);

    public List listPlayers();

    public void updatePlayerScore(int id, int won, int lost);

}
