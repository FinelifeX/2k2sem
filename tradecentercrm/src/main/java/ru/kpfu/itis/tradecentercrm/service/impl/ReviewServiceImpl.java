package ru.kpfu.itis.tradecentercrm.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.tradecentercrm.entity.Review;
import ru.kpfu.itis.tradecentercrm.entity.User;
import ru.kpfu.itis.tradecentercrm.repository.ReviewRepository;
import ru.kpfu.itis.tradecentercrm.service.ReviewService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Bulat Murtazin on 05.06.2018 -> 10:19
 * KPFU ITIS 11-601
 **/

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getThreeReviews() {
        List<Review> result = new ArrayList<>();
        Optional<Review> firstOptional = reviewRepository.findById((long) 1);
        firstOptional.ifPresent(result::add);
        Optional<Review> secondOptional = reviewRepository.findById((long) 101);
        secondOptional.ifPresent(result::add);
        Optional<Review> thirdOptional = reviewRepository.findById((long) 151);
        thirdOptional.ifPresent(result::add);
        return result;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void addReview(User author, String content, MultipartFile image) throws IOException {
        byte[] fileByteArray = image.getBytes();
        Review review = Review.builder().author(author)
                .content(content).image(fileByteArray).build();
        reviewRepository.save(review);
    }

    @Override
    public void editReview(long id, String content) {
        Review review = reviewRepository.findById(id).get();
        review.setContent(content);
        reviewRepository.save(review);
    }
}
