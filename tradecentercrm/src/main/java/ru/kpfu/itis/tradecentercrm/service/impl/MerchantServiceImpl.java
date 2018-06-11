package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.tradecentercrm.entity.Merchant;
import ru.kpfu.itis.tradecentercrm.repository.MerchantRepository;
import ru.kpfu.itis.tradecentercrm.service.MerchantService;

import java.util.List;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 1:32
 * KPFU ITIS 11-601
 **/

@Service
public class MerchantServiceImpl implements MerchantService {

    private MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }


    @Override
    public List<Merchant> getAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant getById(long id) {
        return merchantRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        merchantRepository.deleteById(id);
    }
}
