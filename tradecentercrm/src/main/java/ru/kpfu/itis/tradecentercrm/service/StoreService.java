package ru.kpfu.itis.tradecentercrm.service;

import ru.kpfu.itis.tradecentercrm.entity.Store;

import java.util.List;

/**
 * Created by Bulat Murtazin on 05.06.2018 -> 11:18
 * KPFU ITIS 11-601
 **/


public interface StoreService {
    List<Store> getAll();
    Store getById(long id);
    void deleteById(long id);
    //TODO add new Store to database
}
