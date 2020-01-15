package com.tempstructures.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tempstructures.userservice.services.UserServiceProducer;

@RestController
@RequestMapping(value = "/")
public class UserServiceKafkaController {
	private final UserServiceProducer producer;

	@Autowired
	public UserServiceKafkaController(UserServiceProducer producer) {
		this.producer = producer;
	}
	
	@PostMapping(value = "/carParked")
	public void carParkedEndpoint(@RequestParam("carregnumber") String carRegNumber, @RequestParam("parkingid") String parkingID, @RequestParam("parkingdatetime") String parkingDateTime) {
		//create a message digest for parking event and publish on parkingTopic at Kafka
	}

	@PostMapping(value = "/publishToKafka")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producer.sendMessage(message);
	}
}
