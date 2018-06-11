package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 22:04
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String title;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne
    @JoinColumn(name = "organiser_id")
    private User organiser;
}
