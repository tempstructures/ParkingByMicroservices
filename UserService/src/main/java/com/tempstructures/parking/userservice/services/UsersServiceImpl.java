package com.tempstructures.parking.userservice.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tempstructures.parking.userservice.models.Users;
import com.tempstructures.parking.userservice.repository.UsersRepository;


@Service
public class UsersServiceImpl implements UsersService {
 
    // The  repository will use the Mongodb-Repository to perform the database operations.
    @Autowired
    UsersRepository userRepo;
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.UsersService#createUser(java.util.List)
     */
    @Override
    public void createUser(Users user) {
    	userRepo.save(user);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.UsersService#getAllUsers()
     */
    @Override
    public Collection<Users> getAllUsers() {
        return userRepo.findAll();
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.UsersService#findUserById(int)
     */
    @Override
    public Optional<Users> findUserById(String id) {
        return userRepo.findById(id);
     
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.UsersService#deleteUserById(int)
     */
    @Override
    public void deleteUserById(String id) {
    	userRepo.deleteById(id);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.UsersService#updateUser(int)
     */
    @Override
    public void updateUser(Users user) {
    	userRepo.save(user);
    }
 
    /* (non-Javadoc)
     * @see com.assignment.springboot.mongo.service.UsersService#deleteAllUsers()
     */
    @Override
    public void deleteAllUsers() {
    	userRepo.deleteAll();
    }
}