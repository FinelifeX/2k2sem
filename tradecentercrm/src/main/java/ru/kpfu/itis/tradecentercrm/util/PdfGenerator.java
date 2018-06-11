package ru.kpfu.itis.tradecentercrm.util;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.params.Param;

/**
 * Created by Bulat Murtazin on 09.06.2018 -> 18:05
 * KPFU ITIS 11-601
 **/


public class PdfGenerator {

    public static Pdf generateReviewsList() {
        Pdf pdf = new Pdf();
        pdf.addParam(new Param("--disable-external-links"), new Param("--disable-internal-links"),
                new Param("--disable-javascript"));
        pdf.addPageFromUrl("http://localhost:8080/reviews");
        return pdf;
    }

    public static Pdf generateStoresList() {
        Pdf pdf = new Pdf();
        pdf.addParam(new Param("--disable-external-links"), new Param("--disable-internal-links"),
                new Param("--disable-javascript"));
        pdf.addPageFromUrl("http://localhost:8080/stores");
        return pdf;
    }
}
