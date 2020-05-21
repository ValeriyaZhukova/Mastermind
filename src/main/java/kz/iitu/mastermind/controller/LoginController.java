package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class LoginController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Show registration form")
    @RequestMapping(value = "/showSignInForm", method = RequestMethod.GET, produces = "application/json")
    public String displayRegistrationForm()
    {
        return "login-form";
    }

    @ApiOperation(value = "Log in")
    @RequestMapping(value = {"/logInSuccess"}, method = RequestMethod.GET)
    public String saveUser(Model model, @RequestBody User user)
    {
        model.addAttribute("user", user);
        return "login-success";
    }


}
