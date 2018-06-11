package ru.kpfu.itis.tradecentercrm.validator;

import org.apache.commons.validator.EmailValidator;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.tradecentercrm.entity.UserLoginData;
import ru.kpfu.itis.tradecentercrm.form.RegisterForm;
import ru.kpfu.itis.tradecentercrm.repository.UserLoginDataRepository;

import java.util.Optional;

/**
 * Created by Bulat Murtazin on 03.06.2018 -> 21:15
 * KPFU ITIS 11-601
 **/

@Component("register")
public class RegisterValidator implements Validator {

    private EmailValidator emailValidator = EmailValidator.getInstance();

    private UserLoginDataRepository userLoginDataRepository;

    public RegisterValidator(UserLoginDataRepository userLoginDataRepository) {
        this.userLoginDataRepository = userLoginDataRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == RegisterForm.class;
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        RegisterForm registerForm = (RegisterForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.registerForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.registerForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.registerForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "NotEmpty.registerForm.secondName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "NotEmpty.registerForm.contact");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "NotEmpty.registerForm.age");

        if (!errors.hasFieldErrors("username")) {
            Optional<UserLoginData> userLoginDataOptional = userLoginDataRepository.findByUsername(registerForm.getUsername());
            if (userLoginDataOptional.isPresent()) {
                errors.rejectValue("username", "Duplicate.registerForm.userName");
            }
        }

    }
}
