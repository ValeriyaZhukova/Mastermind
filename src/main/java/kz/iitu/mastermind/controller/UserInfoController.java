package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.model.UserInformation;
import kz.iitu.mastermind.repository.UserInfoRepository;
import kz.iitu.mastermind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.io.IOException;

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
public class UserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    UserInfoRepository userInfoRepository;

    @ApiOperation(value = "Show user information adding form")
    @RequestMapping(value = { "/showUserInfoAddForm/" }, method = RequestMethod.GET)
    public String displayRegistrationForm(UserInformation userInformation, Long user_id)
    {
        return "user-info-add";
    }

    @ApiOperation(value = "Add user info")
    @RequestMapping(value = {"/user-info/add/"}, method = RequestMethod.POST)
    public String saveUserInformation(Model model, @RequestParam("firstName") String firstName,
                                                   @RequestParam("lastName") String lastName,
                                                   @RequestParam("email") String email,
                                                   @RequestParam("birthDate") String birthDate,
                                                   @RequestParam("gender") String gender,
                                                   @CookieValue(value = "userID", defaultValue = "11") String userID)
    {
        Long user_id = Long.parseLong(userID);
        System.out.println("user id: " + user_id);
        User currentUser = userService.getUserByID(user_id);
        System.out.println("currentUser:" + currentUser);
        UserInformation userInformation = new UserInformation(firstName, lastName, birthDate, gender, email, currentUser);
        model.addAttribute("userInformation", userInformation);

        userInfoRepository.saveAndFlush(userInformation);


        return "index";
    }
}
