package com.nagp.ucp.rating.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.ucp.rating.entity.Rating;
import com.nagp.ucp.rating.repository.RatingRepository;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public List<Rating> getRatings(int serviceId) {

        List<Rating> ratings = ratingRepository.findByServiceId(serviceId);
        if (null != ratings && !ratings.isEmpty()) {
            return ratings;
        }
        return new ArrayList<>();
    }

    public void postRating(int serviceId, String name, double totalRating, String comment) {

        Rating rating = new Rating();
        rating.setServiceId(serviceId);
        rating.setName(name);
        rating.setTotalRating(totalRating);
        rating.setComment(comment);
        ratingRepository.save(rating);

    }
}
