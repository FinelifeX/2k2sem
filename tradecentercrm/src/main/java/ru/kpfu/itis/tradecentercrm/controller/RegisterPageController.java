package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.tradecentercrm.form.RegisterForm;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;
import ru.kpfu.itis.tradecentercrm.validator.RegisterValidator;

import javax.validation.Valid;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 20:44
 * KPFU ITIS 11-601
 **/

@Controller
public class RegisterPageController {

    private RegisterValidator registerValidator;

    private UserInfoService userInfoService;

    public RegisterPageController(RegisterValidator registerValidator,
                                  UserInfoService userInfoService) {
        this.registerValidator = registerValidator;
        this.userInfoService = userInfoService;
    }

    @InitBinder("register")
    protected void initBinder(WebDataBinder webDataBinder) {
       webDataBinder.addValidators(registerValidator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage() {
        return "register";
    }

    @RequestMapping(value = "/register-unsuccessful", method = RequestMethod.GET)
    public String registerUnsuccessful() {
        return "redirect:/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(@Valid @ModelAttribute("form")RegisterForm form,
                                  BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0));
            return "redirect:/register-unsuccessful";
        }
        userInfoService.registerNewUser(form);
        return "redirect:/register-successful";
    }

    @RequestMapping(value = "/register-successful", method = RequestMethod.GET)
    public String registerSuccessful() {
        return "redirect:/login";
    }
}
