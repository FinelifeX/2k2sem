package ru.kpfu.itis.tradecentercrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;

import java.util.Optional;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 22:40
 * KPFU ITIS 11-601
 **/


public interface UserLoginDataRepository extends JpaRepository<UserLoginData, Long> {
    Optional<UserLoginData> findByUsername(String username);
    Optional<UserLoginData> findById(long id);
    Optional<UserLoginData> findByRelatedUser(User user);
}
