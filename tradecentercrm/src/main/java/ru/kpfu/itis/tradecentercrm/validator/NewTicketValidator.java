package ru.kpfu.itis.tradecentercrm.validator;

import org.apache.commons.validator.EmailValidator;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.form.TicketForm;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;

/**
 * Created by Bulat Murtazin on 07.06.2018 -> 17:44
 * KPFU ITIS 11-601
 **/

@Component("newTicket")
public class NewTicketValidator implements Validator {

    private UserInfoService userInfoService;

    private EmailValidator emailValidator = EmailValidator.getInstance();

    public NewTicketValidator(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == TicketForm.class;
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        TicketForm ticketForm = (TicketForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "receiver", "NotEmpty.ticketForm.receiver");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.ticketForm.title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "NotEmpty.ticketForm.content");

        if (!errors.hasFieldErrors("receiver")) {
            User user = userInfoService.findUserByUsername(ticketForm.getReceiver());
            if (user == null) {
                errors.rejectValue("receiver", "Such user doesn't exist!");
            }
        }
    }
}
