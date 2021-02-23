package com.nagp.ucp.rating;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "com.nagp.ucp" })
public class UcpServiceRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcpServiceRatingApplication.class, args);
	}

	// Configured For Rabbit Listener
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
