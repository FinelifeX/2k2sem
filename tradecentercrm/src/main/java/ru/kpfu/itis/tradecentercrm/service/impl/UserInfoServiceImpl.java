package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserRole;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserStatus;
import ru.kpfu.itis.tradecentercrm.form.RegisterForm;
import ru.kpfu.itis.tradecentercrm.repository.UserLoginDataRepository;
import ru.kpfu.itis.tradecentercrm.repository.UserRepository;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;

import java.util.List;

/**
 * Created by Bulat Murtazin on 05.06.2018 -> 10:47
 * KPFU ITIS 11-601
 **/

@Service
public class UserInfoServiceImpl implements UserInfoService{

    private UserRepository userRepository;
    private UserLoginDataRepository userLoginDataRepository;
    private PasswordEncoder encoder;


    public UserInfoServiceImpl(UserRepository userRepository,
                               PasswordEncoder encoder,
                               UserLoginDataRepository userLoginDataRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.userLoginDataRepository = userLoginDataRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserLoginData> getAllUsersLoginData() {
        return userLoginDataRepository.findAll();
    }

    @Override
    public void registerNewUser(RegisterForm form) {
        User user = User.builder().firstName(form.getFirstName()).secondName(form.getSecondName())
                .age(form.getAge()).contact(form.getContact()).role(UserRole.USER).build();
        UserLoginData userLoginData = UserLoginData.builder().relatedUser(user).role(user.getRole())
                .status(UserStatus.CONFIRMED).username(form.getUsername())
                .passwordHashed(encoder.encode(form.getPassword())).build();
        userRepository.save(user);
        userLoginDataRepository.save(userLoginData);
    }

    @Override
    public User findUserByUsername(String username) {
        return userLoginDataRepository.findByUsername(username).get().getRelatedUser();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteByUserId(long id) {
        UserLoginData userLoginData = userLoginDataRepository.findByRelatedUser(userRepository.findById(id).get()).get();
        userRepository.deleteById(id);
        userLoginDataRepository.deleteById(userLoginData.getId());
    }

    @Override
    public UserLoginData findUserLoginDataByUserId(long id) {
        return userLoginDataRepository.findByRelatedUser(userRepository.findById(id).get()).get();
    }

    @Override
    public void editUser(long id, String username,
                         String passwordHashed, String role,
                         String status, String fullName,
                         int age, String contact) {
        User user = userRepository.findById(id).get();
        UserLoginData userLoginData = userLoginDataRepository.findByRelatedUser(user).get();
        UserRole userRole = UserRole.USER;
        if (role.equals(UserRole.DIRECTOR.name())) {
            userRole = UserRole.DIRECTOR;
        } else if (role.equals(UserRole.ADMIN.name())) {
            userRole =  UserRole.ADMIN;
        }
        user.setRole(userRole);
        userLoginData.setRole(userRole);
        UserStatus userStatus = UserStatus.CONFIRMED;
        if (status.equals(UserStatus.BANNED.name())) {
            userStatus = UserStatus.BANNED;
        }
        else if (status.equals(UserStatus.UNCONFIRMED.name())) {
            userStatus = UserStatus.UNCONFIRMED;
        }
        userLoginData.setStatus(userStatus);
        String[] nameParts = fullName.split(" ");
        user.setFirstName(nameParts[0]);
        user.setSecondName(nameParts[1]);
        user.setAge(age);
        user.setContact(contact);
        userRepository.save(user);
        userLoginDataRepository.save(userLoginData);
    }

    @Override
    public User findUserByFullName(String firstName, String secondName) {
        return userRepository.findByFirstNameAndSecondName(firstName, secondName).orElse(null);
    }
}
