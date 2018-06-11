package ru.kpfu.itis.tradecentercrm.service;

import ru.kpfu.itis.tradecentercrm.entity.Merchant;

import java.util.List;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:11
 * KPFU ITIS 11-601
 **/


public interface MerchantService {
    List<Merchant> getAll();
    Merchant getById(long id);
    //TODO add new Merchant to database
    void deleteById(long id);
}
