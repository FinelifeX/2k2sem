package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.tradecentercrm.form.TicketForm;
import ru.kpfu.itis.tradecentercrm.service.TicketService;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;
import ru.kpfu.itis.tradecentercrm.validator.NewTicketValidator;

import javax.validation.Valid;

/**
 * Created by Bulat Murtazin on 07.06.2018 -> 19:53
 * KPFU ITIS 11-601
 **/

@Controller
public class AddTicketController {

    private UserInfoService userInfoService;
    private NewTicketValidator newTicketValidator;
    private TicketService ticketService;

    public AddTicketController(UserInfoService userInfoService,
                               NewTicketValidator newTicketValidator,
                               TicketService ticketService) {
        this.userInfoService = userInfoService;
        this.newTicketValidator = newTicketValidator;
        this.ticketService = ticketService;
    }

    @InitBinder("newTicket")
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(newTicketValidator);
    }

    @RequestMapping(value = "/user/{id}/new-ticket", method = RequestMethod.GET)
    public String showNewTicketPage(@PathVariable String id, @ModelAttribute("model")ModelMap model) {
        model.addAttribute("user", userInfoService.
                findUserByUsername(userInfoService.findUserLoginDataByUserId(StringTrimmer.trimStringToLong(id)).getUsername()));
        model.addAttribute("username", userInfoService.findUserLoginDataByUserId(StringTrimmer.trimStringToLong(id)).getUsername());
        return "ticket-add";
    }

    @RequestMapping(value = "/user/{id}/new-ticket", method = RequestMethod.POST)
    public String sendNewTicket(@Valid @ModelAttribute("form")TicketForm form, @PathVariable String id,
                                BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0));
            return "redirect:/user/" + StringTrimmer.trimStringToLong(id) + "/new-ticket/unsuccessful";
        }
        ticketService.addTicket(form);
        return "/user/" + StringTrimmer.trimStringToLong(id) + "/new-ticket/successful";
    }

    @RequestMapping(value = "/user/{id}/new-ticket/unsuccessful", method = RequestMethod.GET)
    public String redirectAfterError(@PathVariable String id) {
        return "redirect:/user/" + StringTrimmer.trimStringToLong(id) + "/new-ticket";
    }

    @RequestMapping(value = "/user/{id}/new-ticket/successful", method = RequestMethod.POST)
        public String redirectAfterSuccess(@PathVariable String id) {
            return "redirect:/user/" + StringTrimmer.trimStringToLong(id);
        }

}
