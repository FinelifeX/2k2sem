package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tradecentercrm.service.*;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:09
 * KPFU ITIS 11-601
 **/

@Controller
public class AdminPageController {

    private UserInfoService userInfoService;
    private TicketService ticketService;

    public AdminPageController(UserInfoService userInfoService, TicketService ticketService) {
        this.userInfoService = userInfoService;
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String showControlPanel() {
        return "admin/controlpanel";
    }

    @RequestMapping(value = "/admin/me", method = RequestMethod.GET)
    public String toProfile(Authentication authentication) {
        return "redirect:/user/" + userInfoService.findUserByUsername(authentication.getName()).getId();
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String showUsersPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("users", userInfoService.getAllUsers());
        return "admin/users-control";
    }

    @RequestMapping(value = "/admin/user/{id}/edit", method = RequestMethod.GET)
    public String editUser(@PathVariable String id, @ModelAttribute("model")ModelMap modelMap) {
        modelMap.addAttribute("user", userInfoService.findUserById(StringTrimmer.trimStringToLong(id)));
        modelMap.addAttribute("userLoginData", userInfoService.findUserLoginDataByUserId(StringTrimmer.trimStringToLong(id)));
        return "edit/user-edit";
    }

    @RequestMapping(value = "/admin/user/{id}/edit", method = RequestMethod.POST)
    public String editUserConfirm(@PathVariable String id,
                                       @RequestParam String username,
                                       @RequestParam String passwordHashed,
                                       @RequestParam String role,
                                       @RequestParam String status,
                                       @RequestParam String fullName,
                                       @RequestParam int age,
                                       @RequestParam String contact) {
        userInfoService.editUser(StringTrimmer.trimStringToLong(id), username, passwordHashed, role, status, fullName, age, contact);
        return "redirect:/admin/user/" + StringTrimmer.trimStringToLong(id) + "/edit/success";
    }

    @RequestMapping(value = "/admin/user/{id}/edit/success", method = RequestMethod.GET)
    public String editUserSuccess(@PathVariable String id) {
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/user/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String  id) {
        userInfoService.deleteByUserId(StringTrimmer.trimStringToLong(id));
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/tickets", method = RequestMethod.GET)
    public String showTicketsPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("tickets", ticketService.getAll());
        return "admin/tickets-control";
    }

    @RequestMapping(value = "/admin/ticket/{id}/edit", method = RequestMethod.GET)
    public String editTicket(@PathVariable String  id, @ModelAttribute("model") ModelMap model) {
        model.addAttribute( "ticket" ,ticketService.getTicketById(StringTrimmer.trimStringToLong(id)));
        return "edit/ticket-edit";
    }

    @RequestMapping(value = "/admin/ticket/{id}/edit", method = RequestMethod.POST)
    public String editTicketConfirm(@PathVariable String  id,
                                    @RequestParam String title,
                                    @RequestParam String content,
                                    @RequestParam String answer,
                                    @RequestParam String status) {
        ticketService.editTicket(StringTrimmer.trimStringToLong(id), title, content, answer, status);
        return "redirect:/admin/ticket/" + StringTrimmer.trimStringToLong(id) + "/edit/success";
    }

    @RequestMapping(value = "/admin/ticket/{id}/edit/success", method = RequestMethod.GET)
    public String editTicketSuccess() {
        return "redirect:/admin/tickets";
    }

    @RequestMapping(value = "/admin/ticket/{id}/delete", method = RequestMethod.GET)
    public String deleteTicket(@PathVariable String id) {
        ticketService.deleteById(StringTrimmer.trimStringToLong(id));
        return "redirect:/admin/tickets";
    }

    @RequestMapping(value = "/admin/stores", method = RequestMethod.GET)
    public String showStoresPage() {
        return "redirect:/director/stores";
    }

    @RequestMapping(value = "/admin/reviews", method = RequestMethod.GET)
    public String showReviewsPage() {
        return "redirect:/director/reviews";
    }

    @RequestMapping(value = "/admin/merchants", method = RequestMethod.GET)
    public String showMerchantsPage() {
        return "redirect:/director/merchants";
    }

    @RequestMapping(value = "/admin/events", method = RequestMethod.GET)
    public String showEventsPage() {
        return "redirect:/director/events";
    }
}
