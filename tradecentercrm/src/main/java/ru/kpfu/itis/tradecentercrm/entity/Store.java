package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Bulat Murtazin on 02.04.2018 -> 13:11
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;

    @OneToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

}
