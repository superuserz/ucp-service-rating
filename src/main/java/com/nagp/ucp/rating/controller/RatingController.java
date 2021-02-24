package com.nagp.ucp.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.ucp.common.exception.UCPException;
import com.nagp.ucp.common.responses.BaseResponse;
import com.nagp.ucp.rating.entity.Rating;
import com.nagp.ucp.rating.service.RatingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {

	@Autowired
	RatingService ratingService;

	@GetMapping("/{serviceId}")
	@ApiOperation(value = "Get Ratings based on serviceId")
	public BaseResponse<List<Rating>> getRating(@PathVariable int serviceId) throws UCPException {
		return new BaseResponse<>(ratingService.getRatings(serviceId));
	}

	@PostMapping("/post")
	@ApiOperation(value = "Post a new Rating for a Service")
	public BaseResponse<Void> postRating(@RequestParam int serviceId, @RequestParam String name,
			@RequestParam double rating, @RequestParam String comment) {
		ratingService.postRating(serviceId, name, rating, comment);
		return new BaseResponse<>();
	}
}
