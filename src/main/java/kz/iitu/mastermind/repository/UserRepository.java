package kz.iitu.mastermind.repository;

import kz.iitu.mastermind.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
