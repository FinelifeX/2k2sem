package ru.kpfu.itis.tradecentercrm.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.tradecentercrm.entity.Review;
import ru.kpfu.itis.tradecentercrm.service.ReviewService;
import ru.kpfu.itis.tradecentercrm.service.UserInfoService;
import ru.kpfu.itis.tradecentercrm.util.PdfGenerator;
import ru.kpfu.itis.tradecentercrm.util.StringTrimmer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 28.05.2018 -> 8:08
 * KPFU ITIS 11-601
 **/

@Controller
public class ReviewsPageController {

    private ReviewService reviewService;
    private UserInfoService userInfoService;

    public ReviewsPageController(ReviewService reviewService, UserInfoService userInfoService) {
        this.reviewService = reviewService;
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public String showReviews(@ModelAttribute("model")ModelMap model) {
        List<Review> reviews = reviewService.getAll();
        model.addAttribute("reviews", reviews);
        return "allreviews";
    }

    @RequestMapping(value = "/reviews/download", method = RequestMethod.GET)
    public String downloadList() throws IOException, InterruptedException {
        PdfGenerator.generateReviewsList().saveAs("c:/users/user/downloads/all-reviews.pdf");
        return "redirect:/reviews";
    }

    @RequestMapping(value = "/review/{id}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] imageUrl(@PathVariable("id")String id) throws IOException {
        return reviewService.getById(StringTrimmer.trimStringToLong(id)).getImage();
    }

    @RequestMapping(value = "/review/{id}", method = RequestMethod.GET)
    public String showSingleReview(@ModelAttribute("model")ModelMap model, Authentication authentication,
                                   @PathVariable("id") String id) throws IOException {
        boolean belongs = false;
        if (authentication != null) {
            long currentUserId = userInfoService.findUserByUsername(authentication.getName()).getId();
            if (reviewService.getById(StringTrimmer.trimStringToLong(id)).getAuthor().getId() == currentUserId) {
                belongs = true;
            }
        }
        Review review = reviewService.getById(StringTrimmer.trimStringToLong(id));
        boolean hasImage = false;
        if (review.getImage() != null) {
            hasImage = true;
        }
        model.addAttribute("hasImage", hasImage);
        model.addAttribute("review", review);
        model.addAttribute("belongs", belongs);
        return "review";
    }

    @RequestMapping(value = "/review/{id}/edit", method = RequestMethod.POST)
    public String showEditReviewPage(@ModelAttribute("model")ModelMap model, @PathVariable("id")String id,
                                     @RequestParam(value = "content", defaultValue = " ") String content) {
        String shownContent = content.length() > 30 ? content.substring(0, 30) : content;
        model.addAttribute("review", reviewService.getById(StringTrimmer.trimStringToLong(id)));
        model.addAttribute("content", shownContent);
        return "review-edit";
    }

    @RequestMapping(value = "/review/{id}/edit-successful", method = RequestMethod.POST)
    public String redirectAfterSuccess(@PathVariable("id")String id, @RequestParam("content")String content) {
        reviewService.editReview(StringTrimmer.trimStringToLong(id), content);
        return "redirect:/review/" + StringTrimmer.trimStringToLong(id);
    }

    @RequestMapping(value = "/review/{id}/delete", method = RequestMethod.GET)
    public String redirectAfterDelete(@PathVariable("id")String id, Authentication authentication) {
        reviewService.deleteById(StringTrimmer.trimStringToLong(id));
        return "redirect:/user/" + userInfoService.findUserByUsername(authentication.getName()).getId();
    }

    @RequestMapping(value = "/review/add-successful", method = RequestMethod.POST)
    public String addSuccessfulRedirect(@RequestParam("userId")String id,
                                        @RequestParam("content")String content,
                                        @RequestParam("file")MultipartFile file) throws IOException {
        reviewService.addReview(userInfoService.findUserById(StringTrimmer.trimStringToLong(id)), content, file);
        return "redirect:/user/" + id;
    }
}
