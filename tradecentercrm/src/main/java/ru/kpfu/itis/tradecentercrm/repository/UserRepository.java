package ru.kpfu.itis.tradecentercrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.tradecentercrm.entity.User;

import java.util.Optional;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 22:39
 * KPFU ITIS 11-601
 **/


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirstNameAndSecondName(String firstName, String secondName);
}
