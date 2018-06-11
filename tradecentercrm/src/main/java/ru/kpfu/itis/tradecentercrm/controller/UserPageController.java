package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.repository.UserLoginDataRepository;
import ru.kpfu.itis.tradecentercrm.repository.UserRepository;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by Bulat Murtazin on 27.05.2018 -> 17:29
 * KPFU ITIS 11-601
 **/

@Controller
public class UserPageController {

    private UserRepository userRepository;
    private UserLoginDataRepository userLoginDataRepository;
    private UserInfoService userInfoService;

    public UserPageController(UserRepository userRepository, UserLoginDataRepository userLoginDataRepository,
                              UserInfoService userInfoService) {
        this.userRepository = userRepository;
        this.userLoginDataRepository = userLoginDataRepository;
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUserPage(@ModelAttribute("model")ModelMap model,
                               @PathVariable("id")String id,
                               Authentication authentication) {
        Optional<User> userOptional = userRepository.findById(StringTrimmer.trimStringToLong(id));
        User user = userOptional.get();
        Optional<UserLoginData> loginDataOptional =  userLoginDataRepository.findByRelatedUser(user);
        UserLoginData loginData = loginDataOptional.get();
        boolean me = true;
        if (StringTrimmer.trimStringToLong(id) != userLoginDataRepository.findByUsername(authentication.getName()).get().getRelatedUser().getId()) {
            me = false;
        }
        model.addAttribute("me", me);
        model.addAttribute("user", user);
        model.addAttribute("userLoginData", loginData);
        return "user";
    }

    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public String showMyPage(Authentication authentication) {
        User user = userInfoService.findUserByUsername(authentication.getName());
        return "redirect:/user/" + user.getId() + "";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            request.getSession().invalidate();
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/user/{id}/add-review", method = RequestMethod.GET)
    public String redirectAddReview(@ModelAttribute("model")ModelMap model,
                                    @PathVariable("id")String id) {
        model.addAttribute("userId", StringTrimmer.trimStringToLong(id));
        return "review-add";
    }
}
