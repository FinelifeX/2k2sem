package ru.kpfu.itis.tradecentercrm.security.details;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.repository.UserLoginDataRepository;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 13:45
 * KPFU ITIS 11-601
 **/

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserLoginDataRepository userLoginDataRepository;

    public UserDetailsServiceImpl(UserLoginDataRepository userLoginDataRepository) {
        this.userLoginDataRepository = userLoginDataRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginData userLoginData = userLoginDataRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("User with username " + username + " doesn't exist!")
        );
        return new UserDetailsImpl(userLoginData);
    }
}
