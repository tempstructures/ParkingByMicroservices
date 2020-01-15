package com.tempstructures.parkingservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(ParkingServiceProducer.class);
	private static final String TOPIC = "parking";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		logger.info(String.format("$$ -> Producing message --> %s", message));
		this.kafkaTemplate.send(TOPIC, message);
	}
}
