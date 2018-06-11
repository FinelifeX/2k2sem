package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.tradecentercrm.entity.Store;
import ru.kpfu.itis.tradecentercrm.service.StoreService;
import ru.kpfu.itis.tradecentercrm.util.PdfGenerator;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 28.05.2018 -> 18:47
 * KPFU ITIS 11-601
 **/

@Controller
public class StoresPageController {

    private StoreService storeService;

    public StoresPageController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public String showAllStores(@ModelAttribute("model")ModelMap model) {
        List<Store> stores = storeService.getAll();
        model.addAttribute("stores", stores);
        return "allstores";
    }

    @RequestMapping(value = "/stores/download", method = RequestMethod.GET)
    public String downloadList() throws IOException, InterruptedException {
        PdfGenerator.generateStoresList().saveAs("c:/users/user/downloads/all-stores.pdf");
        return "redirect:/stores";
    }

    @RequestMapping(value = "/store/{id}", method = RequestMethod.GET)
    public String showSingleStore(@PathVariable String id, @ModelAttribute("model")ModelMap map) {
        map.addAttribute("store", storeService.getById(StringTrimmer.trimStringToLong(id)));
        return "store";
    }

}
