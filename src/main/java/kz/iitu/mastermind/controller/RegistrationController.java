package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.model.UserInformation;
import kz.iitu.mastermind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
public class RegistrationController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Show registration form")
    @RequestMapping(value = { "/showSignUpForm" }, method = RequestMethod.GET)
    public String displayRegistrationForm(User user)
    {
        return "registration-form";
    }

    @ApiOperation(value = "Register new user with username and password")
    @RequestMapping(value = {"/saveSignUpForm/"}, method = RequestMethod.POST)
    public String saveUser(Model model, @RequestParam("username") String username, @RequestParam("password") String password, UserInformation userInformation, HttpServletResponse response)
    {
        Cookie cookie;
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        userService.createUser(user);
        User newUser = (User) userService.loadUserByUsername(username);
        System.out.println("newUser: " + newUser);
        model.addAttribute("user", newUser);

        cookie = new Cookie("userID", user.getId().toString());
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "registration-success";
    }
}
