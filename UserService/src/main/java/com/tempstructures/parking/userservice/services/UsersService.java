package com.tempstructures.parking.userservice.services;

import java.util.Collection;
import java.util.Optional;

import com.tempstructures.parking.userservice.models.Users;

public interface UsersService {
	
	
	/**
	 * Method to create new users in the db using mongo-db repository.
	 * @param emp
	 */
	public void createUser(Users user);

	/**
	 * Method to fetch all users from the db using mongo-db repository.
	 * @return
	 */
	public Collection<Users> getAllUsers();

	/**
	 * Method to fetch user by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<Users> findUserById(String id);

	/**
	 * Method to delete user by id using mongo-db repository.
	 * @param id
	 */
	public void deleteUserById(String id);

	/**
	 * Method to update user by id using mongo-db repository.
	 * @param id
	 */
	public void updateUser(Users user);

	/**
	 * Method to delete all users using mongo-db repository.
	 */
	public void deleteAllUsers();

        
	
}