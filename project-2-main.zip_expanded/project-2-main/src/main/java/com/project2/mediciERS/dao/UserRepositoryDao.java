package com.project2.mediciERS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.mediciERS.entity.User;

@Repository
public interface UserRepositoryDao extends JpaRepository<User, Integer>{
	
	// ______________________________ FINDER METHODS ______________________________________
	
	// GET A USER
	// select * from user_details where user_id=" + userId + "and user_removed=false";
	List<User> findByUserIdAndUserRemoved(Integer userId, boolean userRemoved);
	
	// GET ALL USERS
	// select * from user_deatils where user_type='employee' and user_removed=false";
	List<User> findByUserTypeAndUserRemoved(String userType, boolean userRemoved);
	
	// VALIDATE USER
	/* select * from user_details where user_id=" + userPojo.getUserId() 
	 * + " and user_password='" + userPojo.getUserPassword() + "' and user_removed=false"; */
	List<User> findByUserIdAndUserPasswordAndUserRemoved(Integer userId, String userPassword, boolean userRemoved);
	

}
