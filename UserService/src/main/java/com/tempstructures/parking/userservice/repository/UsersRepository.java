package com.tempstructures.parking.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.tempstructures.parking.userservice.models.Users;


@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
 
}

