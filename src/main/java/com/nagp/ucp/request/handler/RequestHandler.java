package com.nagp.ucp.request.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagp.ucp.common.constant.QueueConstants;
import com.nagp.ucp.common.request.AddRatingRequest;
import com.nagp.ucp.rating.service.RatingService;

@Component
public class RequestHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);

	@Autowired
	private RatingService ratingService;

	@RabbitListener(queues = QueueConstants.QUEUE)
	public void processAddRating(AddRatingRequest request) {

		try {
			LOGGER.info("Request Received : {}", request);
			ratingService.postRating(request.getServiceId(), request.getName(), request.getTotalRating(),
					request.getComment());
		} catch (Exception e) {
			LOGGER.error("Exception while processing request");
		}
	}
}
