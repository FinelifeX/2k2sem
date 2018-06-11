package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 14:07
 * KPFU ITIS 11-601
 **/

@Controller
public class LoginPageController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Authentication authentication) {
        if (authentication != null) {
            Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
            for (GrantedAuthority authority : grantedAuthorities) {
                if (authority.getAuthority().equals("ADMIN")) {
                    return "redirect:/admin";
                }
            }
            return "redirect:/user/me";
        }
        return "login";
    }
}
