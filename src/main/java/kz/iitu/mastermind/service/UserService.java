package kz.iitu.mastermind.service;

import kz.iitu.mastermind.model.Role;
import kz.iitu.mastermind.model.Score;
import kz.iitu.mastermind.model.User;
import kz.iitu.mastermind.repository.RoleRepository;
import kz.iitu.mastermind.repository.ScoreRepository;
import kz.iitu.mastermind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository userRoleRepository;

    @Autowired
    ScoreRepository scoreRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserByID(Long id)
    {
        return userRepository.findById(id).get();
    }

    public void createUser(User user)
    {
        List<Role> defaultRole = new ArrayList<>();
        defaultRole.add(userRoleRepository.findByRole("USER"));

        Score defaultScore = new Score(0, 0, 0, user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(defaultRole);
        user.setScore(defaultScore);
        userRepository.saveAndFlush(user);
    }

    public void updateUser(Long id, User user)
    {
        User userDb = userRepository.findById(id).orElse(null);

        if (userDb != null)
        {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.saveAndFlush(userDb);
        }
    }

    public void deleteUser(Long id)
    {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findUserByUsername(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }

        return user;
    }
}
