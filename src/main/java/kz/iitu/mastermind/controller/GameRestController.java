package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.exception.NotFoundException;
import kz.iitu.mastermind.model.Game;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.repository.GameRepository;
import kz.iitu.mastermind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@ApiResponses
    (value	=
        {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code =	401, message = "Not	authorized"),
            @ApiResponse(code =	403, message = "Forbidden"),
            @ApiResponse(code =	404, message = "Resource not found")
        }
    )

@RestController
@RequestMapping("/games")
public class GameRestController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "List game records", response = Game.class, responseContainer = "List")
    @GetMapping("/get")
    public List<Game> getGamesRecords()
    {
        List<Game> games = gameRepository.findAll();
        return games;
    }

    @ApiOperation(value = "Add new game record, update user game statistics")
    @PostMapping("/add/")
    public void addGameRecord(@RequestParam int secretNumber, @RequestParam int numberOfGuesses, @RequestParam boolean win, @RequestParam int score, @RequestParam Long userID)
    {
        User user = userRepository.getOne(userID);
        Game game = new Game();

        if (score > user.getScore().getBestScore())
        {
            user.getScore().setBestScore(score);
        }

        if (win)
        {
            user.getScore().setWon(user.getScore().getWon() + 1);
        }
        else
        {
            user.getScore().setLost(user.getScore().getLost() + 1);
        }

        userRepository.save(user);

        game.setSecretNumber(secretNumber);
        game.setNumberOfGuesses(numberOfGuesses);
        game.setWin(win);
        game.setScore(score);
        game.setUser(user);

        gameRepository.saveAndFlush(game);
    }

    @ApiOperation(value = "Update game record", response = Game.class)
    @PutMapping("/update/{id}")
    public Game updateGameRecord(@PathVariable Long id, @RequestBody Game game) throws NotFoundException
    {
        Game dbGame = null;

        dbGame = gameRepository.findById(id).get();

        if (dbGame != null)
        {
            dbGame.setSecretNumber(game.getSecretNumber());
            dbGame.setNumberOfGuesses(game.getNumberOfGuesses());
            dbGame.setWin(game.isWin());
            dbGame.setScore(game.getScore());

            gameRepository.saveAndFlush(dbGame);
        }
        else
        {
            throw new NotFoundException();
        }

        return dbGame;
    }

    @ApiOperation(value = "Delete game record")
    @DeleteMapping("/delete/{id}")
    public void deleteGameRecord(@PathVariable Long id)
    {
        Game dbGame = null;

        dbGame = gameRepository.findById(id).get();

        if (dbGame != null)
        {
            gameRepository.delete(dbGame);
        }
        else
        {
            throw new NotFoundException();
        }
    }
}
