package kz.iitu.mastermind.repository;

import kz.iitu.mastermind.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
