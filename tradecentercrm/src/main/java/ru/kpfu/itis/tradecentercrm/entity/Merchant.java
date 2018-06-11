package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Bulat Murtazin on 02.04.2018 -> 13:14
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String tradeMark;
    private String description;
}
