package com.tempstructures.parking.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tempstructures.parking.userservice.services.UsersService;
import com.tempstructures.parking.userservice.models.Users;

@RestController
@RequestMapping(value= "/api/users")
public class UsersController {
    
    //@Autowired
    //private Environment env;
    
    
    @Autowired
	UsersService userServ;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    
    
	/**
	 * Method to save users in the db.
	 * @param users
	 * @return
	 */
	@PostMapping(value= "/create")
	public String create(@RequestBody Users users) {
		logger.debug("Saving user.");
		userServ.createUser(users);
		return "User records created.";
	}

	/**
	 * Method to fetch all user from the db.
	 * @return
	 */
	@GetMapping(value= "/getall")
	public Collection<Users> getAll() {
		logger.debug("Getting all Users.");
		return userServ.getAllUsers();
	}

	/**
	 * Method to fetch user by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value= "/getbyid/{user-id}")
	public Optional<Users> getById(@PathVariable(value= "user-id") String id) {
		logger.debug("Getting user with user-id= {}.", id);
		return userServ.findUserById(id);
	}

	/**
	 * Method to update user by id.
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value= "/update/{user-id}")
	public String update(@PathVariable(value= "user-id") String id, @RequestBody Users user) {
		logger.debug("Updating user with user-id= {}.", id);
		user.setId(id);
		userServ.updateUser(user);
		return "user record for user-id= " + id + " updated.";
	}

	/**
	 * Method to delete user by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping(value= "/delete/{user-id}")
	public String delete(@PathVariable(value= "user-id") String id) {
		logger.debug("Deleting user with user-id= {}.", id);
		userServ.deleteUserById(id);
		return "User record for user-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all users from the db.
	 * @return
	 */
	@DeleteMapping(value= "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all users.");
		userServ.deleteAllUsers();
		return "All user records deleted.";
	}
}