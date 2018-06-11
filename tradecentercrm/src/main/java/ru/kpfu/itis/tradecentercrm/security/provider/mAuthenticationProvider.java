package ru.kpfu.itis.tradecentercrm.security.provider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserStatus;
import ru.kpfu.itis.tradecentercrm.repository.UserLoginDataRepository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 13:56
 * KPFU ITIS 11-601
 **/

@Component
public class mAuthenticationProvider implements AuthenticationProvider {

    private UserLoginDataRepository userLoginDataRepository;
    private PasswordEncoder encoder;
    private UserDetailsService userDetailsService;

    public mAuthenticationProvider(UserLoginDataRepository userLoginDataRepository,
                                   PasswordEncoder encoder,
                                   @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userLoginDataRepository = userLoginDataRepository;
        this.encoder = encoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<UserLoginData> userLoginDataOptional = userLoginDataRepository.findByUsername(username);
        if (userLoginDataOptional.isPresent()) {
            UserLoginData userLoginData = userLoginDataOptional.get();

            if (encoder.matches(password, userLoginData.getPasswordHashed())) {
                if (!userLoginData.getStatus().equals(UserStatus.CONFIRMED)) {
                    throw new BadCredentialsException("Confirmation is failed");
                }
            }
            else {
                throw new BadCredentialsException("Invalid login or password");
            }
        }
        else {
            throw new BadCredentialsException("Such user doesn't exist!");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> grantedAuthorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
