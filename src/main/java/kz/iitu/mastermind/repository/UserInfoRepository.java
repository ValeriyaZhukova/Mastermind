package kz.iitu.mastermind.repository;

import kz.iitu.mastermind.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInformation, Long> {
}
