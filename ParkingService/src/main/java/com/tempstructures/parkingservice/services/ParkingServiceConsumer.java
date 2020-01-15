package com.tempstructures.parkingservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceConsumer {
	private final Logger logger = LoggerFactory.getLogger(ParkingServiceConsumer.class);

	@KafkaListener(topics = "parking", groupId = "group_id")
	public void parkingConsume(String message) {
		logger.info(String.format("$$ -> Consumed Message from Parking Topic -> %s", message));
	}
	
	@KafkaListener(topics = "admin", groupId = "group_id")
	public void adminConsume(String message) {
		logger.info(String.format("$$ -> Consumed Message from Admin Topic -> %s", message));
	}
}
