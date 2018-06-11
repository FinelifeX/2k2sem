package ru.kpfu.itis.tradecentercrm.util;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 17:20
 * KPFU ITIS 11-601
 **/


public class StringTrimmer {
    public static long trimStringToLong(String s) {
        return Long.parseLong(s.replaceAll("\\s", ""));
    }
}
