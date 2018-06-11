package ru.kpfu.itis.tradecentercrm.service;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.tradecentercrm.entity.Review;
import ru.kpfu.itis.tradecentercrm.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 27.05.2018 -> 0:01
 * KPFU ITIS 11-601
 **/


public interface ReviewService {
    List<Review> getThreeReviews();
    List<Review> getAll();
    Review getById(long id);
    void deleteById(long id);
    void addReview(User author, String content, MultipartFile image) throws IOException;
    void editReview(long id, String content);
}
