package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.tradecentercrm.entity.Ticket;
import ru.kpfu.itis.tradecentercrm.service.TicketService;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;

/**
 * Created by Bulat Murtazin on 07.06.2018 -> 18:53
 * KPFU ITIS 11-601
 **/

@Controller
public class TicketController {

    private TicketService ticketService;
    private UserInfoService userInfoService;

    public TicketController(TicketService ticketService,
                            UserInfoService userInfoService) {
        this.ticketService = ticketService;
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET)
    public String showTicketInfo(@PathVariable String id, @ModelAttribute("model")ModelMap model,
                                 Authentication authentication) {
        Ticket ticket = ticketService.getTicketById(StringTrimmer.trimStringToLong(id));
        String sender = userInfoService.findUserLoginDataByUserId(ticket.getSender().getId()).getUsername();
        String receiver = userInfoService.findUserLoginDataByUserId(ticket.getReceiver().getId()).getUsername();
        boolean isParticipant =
                userInfoService.findUserByUsername(authentication.getName()).getId() == ticket.getSender().getId() ||
                        userInfoService.findUserByUsername(authentication.getName()).getId() == ticket.getReceiver().getId();
        model.addAttribute("ticket", ticket);
        model.addAttribute("sender", sender);
        model.addAttribute("receiver", receiver);
        model.addAttribute("isParticipant", isParticipant);
        return "ticket";
    }
}
