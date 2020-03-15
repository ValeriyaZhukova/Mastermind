package kz.iitu.mastermind.util;

import kz.iitu.mastermind.models.Player;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper implements RowMapper {

    @Override
    public Player mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Player player = new Player();

        player.setId(resultSet.getInt("ID"));
        player.setUsername(resultSet.getString("Username"));
        player.setWon(resultSet.getInt("Won"));
        player.setLost(resultSet.getInt("Lost"));

        return player;
    }
}
