package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.Event;
import ru.kpfu.itis.tradecentercrm.repository.EventRepository;
import ru.kpfu.itis.tradecentercrm.service.EventService;

import java.util.List;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:35
 * KPFU ITIS 11-601
 **/

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event getById(long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        eventRepository.deleteById(id);
    }
}
