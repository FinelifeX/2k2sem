package ru.kpfu.itis.tradecentercrm.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 21:07
 * KPFU ITIS 11-601
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterForm {

    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private int age;
    private String contact;
}
