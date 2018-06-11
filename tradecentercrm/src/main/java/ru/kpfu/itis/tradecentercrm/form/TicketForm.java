package ru.kpfu.itis.tradecentercrm.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Bulat Murtazin on 07.06.2018 -> 16:58
 * KPFU ITIS 11-601
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketForm {

    private String sender;
    private String receiver;
    private String title;
    private String content;
}
