package ru.kpfu.itis.tradecentercrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.tradecentercrm.entity.Event;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 22:45
 * KPFU ITIS 11-601
 **/


public interface EventRepository extends JpaRepository<Event, Long> {
}
