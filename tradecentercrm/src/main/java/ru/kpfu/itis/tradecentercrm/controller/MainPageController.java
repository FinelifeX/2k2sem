package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.tradecentercrm.service.ReviewService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 23:17
 * KPFU ITIS 11-601
 **/

@Controller
public class MainPageController {

    private ReviewService reviewService;

    public MainPageController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(@ModelAttribute("model")ModelMap map, Authentication authentication,
                              HttpServletRequest request) {
        boolean replacementNeeded = false;
        boolean isAdmin = false;
        boolean isDirector = false;
        if (authentication != null) {
            replacementNeeded = true;

            Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
            for (GrantedAuthority authority : grantedAuthorities) {
                if (authority.getAuthority().equals("ADMIN")) {
                    isAdmin = true;
                }
                if (authority.getAuthority().equals("DIRECTOR")) {
                    isDirector = true;
                }
            }
        }
        map.addAttribute("isDirector", isDirector);
        map.addAttribute("isAdmin", isAdmin);
        map.addAttribute("replacementNeeded", replacementNeeded);
        map.addAttribute("reviews", reviewService.getThreeReviews());
        return "main";
    }
}
