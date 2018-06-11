package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;
import ru.kpfu.itis.tradecentercrm.entity.enums.TicketStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 19:32
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private String title;
    private String content;
    private String answer;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
