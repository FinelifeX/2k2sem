package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 21:38
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String review;
    private int salary;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
