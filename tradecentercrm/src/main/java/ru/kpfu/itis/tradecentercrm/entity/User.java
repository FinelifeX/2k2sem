package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserRole;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 19:05
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String firstName;
    private String secondName;
    private int age;
    private String contact;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Ticket> ticketsSent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Ticket> ticketsReceived;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Review> reviews;

}
