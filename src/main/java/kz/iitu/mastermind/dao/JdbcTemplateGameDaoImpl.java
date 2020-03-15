package kz.iitu.mastermind.dao;

import kz.iitu.mastermind.util.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcTemplateGameDaoImpl implements GameDao{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addNewGameRecord(int id, int secretNumber, int numberOfGuesses, boolean win, int playerID)
    {
        String SQL = "INSERT INTO public.\"Game\"(\n" +
                "\t\"ID\", \"SecretNumber\", \"NumberOfGuesses\", \"Win\", \"PlayerID\")\n" +
                "\tVALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(SQL, id, secretNumber, numberOfGuesses, win, playerID);
        System.out.println("New game record successfully added to database. \nGame id: " + id + "; secret number: " + secretNumber + "; number of guesses: " + numberOfGuesses + "; won? " + win);
    }

    @Override
    public List listGamesByPlayerID(int playerID)
    {
        String SQL = "SELECT \"ID\", \"SecretNumber\", \"NumberOfGuesses\", \"Win\", \"PlayerID\"\n" +
                "\tFROM public.\"Game\"\n" +
                "\tWHERE \"PlayerID\"=?";
        List games = jdbcTemplate.query(SQL, new GameMapper());
        return games;
    }

    @Override
    public List listAllGames()
    {
        String SQL = "SELECT * FROM public.\"Game\"";
        List allGames = jdbcTemplate.query(SQL, new GameMapper());
        return allGames;
    }

    @Override
    public void updateGame(int id, int secretNumber, int numberOfGuesses, boolean win, int playerID)
    {
        String SQL = "UPDATE public.\"Game\"\n" +
                "\tSET \"SecretNumber\"=?, \"NumberOfGuesses\"=?, \"Win\"=?, \"PlayerID\"=?\n" +
                "\tWHERE \"ID\"=?;";

        jdbcTemplate.update(SQL, secretNumber, numberOfGuesses, win, playerID, id);
        System.out.println("Successfully updated");
    }
}
