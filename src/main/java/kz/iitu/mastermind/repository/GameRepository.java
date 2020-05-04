package kz.iitu.mastermind.repository;

import kz.iitu.mastermind.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findGamesByUser_Id(Long userID);
}
