package kz.iitu.mastermind.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.mastermind.exception.NotFoundException;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "List all users", response = User.class, responseContainer = "List")
    @GetMapping("")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get user by ID", response = User.class)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserByID(id);
    }

    @ApiOperation(value	= "Register new user with username and password", response = User.class)
    @PostMapping("/register/")
    public User createUserByUsernamePassword(@RequestParam String username, @RequestParam String password)
    {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        userService.createUser(user);
        User newUser = (User) userService.loadUserByUsername(username);
        return newUser;
    }

    @ApiOperation(value = "Find user by username", response = User.class)
    @GetMapping("/find/")
    public User findByUsername(@RequestParam String username) throws NotFoundException
    {
        User user = null;
        user = (User) userService.loadUserByUsername(username);

        if (user == null)
        {
            throw new NotFoundException();
        }

        return user;
    }

    @ApiOperation(value = "Update user", response = User.class)
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
        User userDB = (User) userService.loadUserByUsername(user.getUsername());
        return userDB;
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
