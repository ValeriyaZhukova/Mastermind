package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.service.UserService;
import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/list-users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "List users in a view")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView listUsers()
    {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

}
