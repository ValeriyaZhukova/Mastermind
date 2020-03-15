package kz.iitu.mastermind.dao;

import kz.iitu.mastermind.models.Player;
import kz.iitu.mastermind.util.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcTemplatePlayerDaoImpl implements PlayerDao {

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
    public void addNewPlayer(int id, String username)
    {
        String SQL = "INSERT INTO public.\"Player\"(\n" +
                "\t\"ID\", \"Username\", \"Won\", \"Lost\")\n" +
                "\tVALUES (?, ?, ?, ?);";
        int won = 0;
        int lost = 0;
        jdbcTemplate.update(SQL, id, username, won, lost);
        System.out.println("Player successfully registered. \nID: " + id + "\nUsername: " + username);
    }

    @Override
    public Player getPlayerByUsername(String username)
    {
        String SQL = "SELECT \"ID\", \"Username\", \"Won\", \"Lost\"\n" +
                "\tFROM public.\"Player\"\n " +
                "\tWHERE \"Username\"=?";
        Player player = (Player) jdbcTemplate.queryForObject(SQL, new Object[]{username}, new PlayerMapper());
        System.out.println(player.toString());
        return player;
    }

    @Override
    public List listPlayers()
    {
        String SQL = "SELECT * FROM public.\"Player\"";
        List players = jdbcTemplate.query(SQL, new PlayerMapper());
        return players;
    }

    @Override
    public void updatePlayerScore(int id, int won, int lost)
    {
        String SQL = "UPDATE public.\"Player\"\n" +
                "\tSET \"Won\"=?, \"Lost\"=?\n" +
                "\tWHERE \"ID\"=?;";

        jdbcTemplate.update(SQL, won, lost, id);
        System.out.println("Player with id " + id + " was successfully updated");
    }
}
