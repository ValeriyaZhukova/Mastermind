package kz.iitu.mastermind.service;

import kz.iitu.mastermind.model.Game;
import kz.iitu.mastermind.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<Game> listGamesByUserID(Long userID)
    {
        List<Game> games = gameRepository.findGamesByUser_Id(userID);
        return games;
    }

    public void saveGame(Game game)
    {
        gameRepository.saveAndFlush(game);
    }

}
