package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.Store;
import ru.kpfu.itis.tradecentercrm.repository.StoreRepository;
import ru.kpfu.itis.tradecentercrm.service.StoreService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Bulat Murtazin on 05.06.2018 -> 11:18
 * KPFU ITIS 11-601
 **/

@Service
public class StoreServiceImpl implements StoreService {

    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getById(long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        return storeOptional.orElse(null);
    }

    @Override
    public void deleteById(long id) {
        storeRepository.deleteById(id);
    }
}
