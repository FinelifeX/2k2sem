package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.Ticket;
import ru.kpfu.itis.tradecentercrm.entity.enums.TicketStatus;
import ru.kpfu.itis.tradecentercrm.form.TicketForm;
import ru.kpfu.itis.tradecentercrm.repository.TicketRepository;
import ru.kpfu.itis.tradecentercrm.service.TicketService;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Bulat Murtazin on 27.05.2018 -> 16:19
 * KPFU ITIS 11-601
 **/

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private UserInfoService userInfoService;

    public TicketServiceImpl(TicketRepository ticketRepository, UserInfoService userInfoService) {
        this.ticketRepository = ticketRepository;
        this.userInfoService = userInfoService;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.orElse(null);
    }

    @Override
    public void addTicket(TicketForm form) {
        Ticket ticket = Ticket.builder()
                .sender(userInfoService.findUserByUsername(form.getSender()))
                .receiver(userInfoService.findUserByUsername(form.getReceiver()))
                .content(form.getContent())
                .answer(" ")
                .date(new Date())
                .title(form.getTitle())
                .status(TicketStatus.OPEN)
                .build();
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteById(long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void editTicket(long id, String title, String content, String answer, String status) {
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setTitle(title);
        ticket.setContent(content);
        ticket.setAnswer(answer);
        TicketStatus ticketStatus = TicketStatus.OPEN;
        if (status.equals(TicketStatus.CLOSED.name())) {
            ticketStatus = TicketStatus.CLOSED;
        }
        else if (status.equals(TicketStatus.PROCESSING.name())) {
            ticketStatus = TicketStatus.PROCESSING;
        }
        ticket.setStatus(ticketStatus);
        ticketRepository.save(ticket);
    }
}
