package com.nagp.ucp.rating.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.ucp.common.exception.UCPException;
import com.nagp.ucp.rating.entity.Rating;
import com.nagp.ucp.rating.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;

	public List<Rating> getRatings(int serviceId) {
		List<Rating> ratings = new ArrayList<>();
		ratings = ratingRepository.findByServiceId(serviceId);
		if (null != ratings && !ratings.isEmpty()) {
			return ratings;
		} else {
			throw new UCPException("ucp.service.rating.001", "No Rating Found for Service ID : " + serviceId);
		}

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
