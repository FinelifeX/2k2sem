package ru.kpfu.itis.tradecentercrm.service;

import ru.kpfu.itis.tradecentercrm.entity.Event;

import java.util.List;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:10
 * KPFU ITIS 11-601
 **/


public interface EventService {
    List<Event> getAll();
    Event getById(long id);
    //TODO add new Event to database
    void deleteById(long id);
}
