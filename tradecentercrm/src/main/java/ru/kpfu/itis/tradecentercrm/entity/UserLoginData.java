package ru.kpfu.itis.tradecentercrm.entity;

import lombok.*;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserRole;
import ru.kpfu.itis.tradecentercrm.entity.enums.UserStatus;

import javax.persistence.*;

/**
 * Created by Bulat Murtazin on 18.05.2018 -> 19:29
 * KPFU ITIS 11-601
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "userlogindata")
public class UserLoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true)
    private String username;

    private String passwordHashed;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "related_user_id")
    private User relatedUser;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
