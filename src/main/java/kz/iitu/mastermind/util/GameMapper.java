package kz.iitu.mastermind.util;

import kz.iitu.mastermind.models.Game;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Game game = new Game();

        game.setId(resultSet.getInt("ID"));
        game.setSecretNumber(resultSet.getInt("SecretNumber"));
        game.setNumberOfGuesses(resultSet.getInt("NumberOfGuesses"));
        game.setWin(resultSet.getBoolean("Win"));
        game.setPlayerID(resultSet.getInt("PlayerID"));

        return game;
    }
}
