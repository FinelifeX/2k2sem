package ru.kpfu.itis.tradecentercrm.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserStatus;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 13:49
 * KPFU ITIS 11-601
 **/


public class UserDetailsImpl implements UserDetails {

    private UserLoginData userLoginData;

    public UserDetailsImpl(UserLoginData userLoginData) {
        this.userLoginData = userLoginData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = new SimpleGrantedAuthority(userLoginData.getRole().toString());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return userLoginData.getPasswordHashed();
    }

    @Override
    public String getUsername() {
        return userLoginData.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userLoginData.getStatus().equals(UserStatus.CONFIRMED);
    }

    public UserLoginData getUserLoginData() {
        return userLoginData;
    }
}
