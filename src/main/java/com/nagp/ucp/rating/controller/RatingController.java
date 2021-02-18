package com.nagp.ucp.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.ucp.rating.entity.Rating;
import com.nagp.ucp.rating.service.RatingService;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/{serviceId}")
    public List<Rating> getRating(@PathVariable int serviceId) {
        return ratingService.getRatings(serviceId);
    }

    @PostMapping("/post")
    public void postRating(@RequestParam int serviceId, @RequestParam String name, @RequestParam double rating,
        @RequestParam String comment) {
        ratingService.postRating(serviceId, name, rating, comment);
    }
}
