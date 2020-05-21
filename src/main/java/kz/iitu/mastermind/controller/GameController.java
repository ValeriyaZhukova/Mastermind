package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.model.Game;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.service.GameService;
import kz.iitu.mastermind.service.MastermindService;
import kz.iitu.mastermind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    MastermindService mastermindService;

    @Autowired
    UserService userService;



    @ApiOperation(value = "List user games by user ID")
    @RequestMapping(value = { "users/games/{id}" }, method = RequestMethod.GET)
    public ModelAndView listGames(@PathVariable("id") Long id)
    {
        List<Game> games = gameService.listGamesByUserID(id);
        ModelAndView modelAndView = new ModelAndView("games");
        modelAndView.addObject("games", games);
        return modelAndView;
    }

    @RequestMapping(value = { "/mastermind" }, method = RequestMethod.GET)
    public String play()
    {
        return "mastermind";
    }

    @RequestMapping(value = {"/gamePlayed/"}, method = RequestMethod.POST)
    public String saveGame(Model model)
    {
        User currentUser = (User) userService.loadUserByUsername("lera");
        mastermindService.generateSecretCode();
        while (!mastermindService.getGame().isWin()) {
            mastermindService.setCurrentGuess("1234");
            mastermindService.makeGuess("1234");
            mastermindService.evaluateGuess(mastermindService.getCurrentGuess());
        }
        mastermindService.setGameAttributes(currentUser);
        System.out.println(mastermindService.getGame().toString());
        return "index";
    }
}
