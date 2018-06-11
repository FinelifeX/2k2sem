package ru.kpfu.itis.tradecentercrm.service;

import ru.kpfu.itis.tradecentercrm.entity.Ticket;
import ru.kpfu.itis.tradecentercrm.form.TicketForm;

import java.util.List;

/**
 * Created by Bulat Murtazin on 27.05.2018 -> 16:18
 * KPFU ITIS 11-601
 **/


public interface TicketService  {
    List<Ticket> getAll();
    Ticket getTicketById(long id);
    void addTicket(TicketForm ticketForm);
    void deleteById(long id);
    void editTicket(long id, String title, String content, String answer, String status);
}
