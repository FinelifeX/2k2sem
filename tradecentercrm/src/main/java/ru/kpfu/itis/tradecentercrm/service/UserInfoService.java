package ru.kpfu.itis.tradecentercrm.service;

import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.form.RegisterForm;

import java.util.List;

/**
 * Created by Bulat Murtazin on 05.06.2018 -> 10:44
 * KPFU ITIS 11-601
 **/


public interface UserInfoService {
    List<User> getAllUsers();
    List<UserLoginData> getAllUsersLoginData();
    void registerNewUser(RegisterForm form);
    User findUserByUsername(String username);
    User findUserById(long id);
    void deleteByUserId(long id);
    UserLoginData findUserLoginDataByUserId(long id);
    void editUser(long id, String username,
                  String passwordHashed, String role,
                  String status, String fullName,
                  int age, String contact);
    User findUserByFullName(String firstName, String secondName);
}
