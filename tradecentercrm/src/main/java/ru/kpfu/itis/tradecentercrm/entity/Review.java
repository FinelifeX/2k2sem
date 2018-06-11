package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 22:15
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String content;

    @Lob
    private byte[] image;

}
