package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tradecentercrm.service.*;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 6:04
 * KPFU ITIS 11-601
 **/

@Controller
public class DirectorPageController {

    private UserInfoService userInfoService;
    private EmployeeService employeeService;
    private EventService eventService;
    private MerchantService merchantService;
    private ReviewService reviewService;
    private StoreService storeService;

    public DirectorPageController(EmployeeService employeeService, EventService eventService,
                                  MerchantService merchantService, ReviewService reviewService,
                                  StoreService storeService, UserInfoService userInfoService) {
        this.employeeService = employeeService;
        this.eventService = eventService;
        this.merchantService = merchantService;
        this.reviewService = reviewService;
        this.storeService = storeService;
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/director", method = RequestMethod.GET)
    public String showControlPanel() {
        return "director/controlpanel";
    }

    @RequestMapping(value = "/director/me", method = RequestMethod.GET)
    public String showProfile(Authentication authentication) {
        return "redirect:/user/" + userInfoService.findUserByUsername(authentication.getName()).getId();
    }

    @RequestMapping(value = "/director/employees", method = RequestMethod.GET)
    public String showEmployeesPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("employees", employeeService.getAll());
        return "director/employees-control";
    }

    @RequestMapping(value = "/director/employee/{id}/edit", method = RequestMethod.GET)
    public String editEmployee(@ModelAttribute("model")ModelMap map, @PathVariable String  id) {
        map.addAttribute("employee", employeeService.getById(StringTrimmer.trimStringToLong(id)));
        return "edit/edit-employee";
    }

    @RequestMapping(value = "/director/employee/{id}/edit", method = RequestMethod.POST)
    public String editSuccess(@RequestParam String review,
                              @RequestParam int salary,
                              @PathVariable String  id) {
        employeeService.editEmployee(StringTrimmer.trimStringToLong(id), review, salary);
        return "redirect:/director/employee/" + StringTrimmer.trimStringToLong(id) + "/edit/success";
    }

    @RequestMapping(value = "/director/employee/{id}/edit/success", method = RequestMethod.GET)
    public String afterEditSuccessRedirect() {
        return "redirect:/director/employees";
    }

    @RequestMapping(value = "/director/employee/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteById(StringTrimmer.trimStringToLong(id));
        return "redirect:/director/employees";
    }

    @RequestMapping(value = "/director/new-employee", method = RequestMethod.GET)
    public String addEmployee() {
        return "add/employee-add";
    }

    @RequestMapping(value = "/director/new-employee", method = RequestMethod.POST)
    public String addEmployeeSuccess(@RequestParam String fullName,
                                     @RequestParam String review,
                                     @RequestParam int salary) {
        employeeService.addEmployee(fullName, review, salary);
        return "redirect:/director/new-employee/success";
    }

    @RequestMapping(value = "/director/new-employee/success", method = RequestMethod.GET)
    public String afterAddSuccessRedirect() {
        return "redirect:/director/employees";
    }

    @RequestMapping(value = "/director/events", method = RequestMethod.GET)
    public String showEventsPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("events", eventService.getAll());
        return "director/events-control";
    }

    @RequestMapping(value = "/director/merchants", method = RequestMethod.GET)
    public String showMerchantsPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("merchants", merchantService.getAll());
        return "director/merchants-control";
    }

    @RequestMapping(value = "/director/reviews", method = RequestMethod.GET)
    public String showReviewsPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("reviews", reviewService.getAll());
        return "director/reviews-control";
    }

    @RequestMapping(value = "/director/review/{id}/delete", method = RequestMethod.GET)
    public String deleteReview(@PathVariable long id) {
        reviewService.deleteById(id);
        return "redirect:/director/reviews";
    }

    @RequestMapping(value = "/director/stores", method = RequestMethod.GET)
    public String showStoresPage(@ModelAttribute("model")ModelMap map) {
        map.addAttribute("stores", storeService.getAll());
        return "director/stores-control";
    }
}
