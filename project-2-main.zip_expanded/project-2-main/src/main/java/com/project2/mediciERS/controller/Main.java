package com.project2.mediciERS.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project2.mediciERS.entity.Reimbursement;
import com.project2.mediciERS.exception.ApplicationException;
import com.project2.mediciERS.pojo.ImagePojo;
import com.project2.mediciERS.pojo.ReimbursementPojo;
import com.project2.mediciERS.pojo.UserPojo;
import com.project2.mediciERS.service.ImageService;
import com.project2.mediciERS.service.ReimbursementService;
import com.project2.mediciERS.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class Main {

	@Autowired
	ReimbursementService reimbursementService;

	@Autowired
	UserService userService;

	@Autowired
	ImageService imageService;


	// ______________________________ REIMBURSEMENT ENDPOINTS _______________________________

	// GET A REIMBURSEMENT
	// http://localhost:8080/api/reimbursements/1 (200 OK)
	@GetMapping("reimbursements/{rbid}")
	ReimbursementPojo getAReimbursement(@PathVariable("rbid") int rbId) throws ApplicationException {
		return reimbursementService.getAReimbursement(rbId);

	}

	// GET ALL PENDING REIMBURSEMENTS (MANAGER) (200 OK)
	// http://localhost:8080/api/reimbursements/manager/view/pending
	@GetMapping("reimbursements/manager/view/{pending}")
	List<ReimbursementPojo> findByRbStatus(@PathVariable("pending") String rbStatus) throws ApplicationException {
		return reimbursementService.getAllPendingRequests(rbStatus);

	}

	// GET ALL RESOLVED REIMBURSEMENTS (MANAGER) (200 OK)
	// http://localhost:8080/api/reimbursements/manager/resolved
	@GetMapping("reimbursements/manager/{resolved}")
	List<ReimbursementPojo> getAllResolvedRequests(@PathParam("resolved") String rbStatus) throws ApplicationException {
		return reimbursementService.getAllResolvedRequests(true);
	}

	// GET A SPECIFIC EMPLOYEE'S REIMBURSEMENTS (MANAGER)
	// http://localhost:8080/api/reimbursements/all/employee/2 (200 OK NULL)
	@GetMapping("reimbursements/all/employee/{userid}")
	List<ReimbursementPojo> getSpecificRequests(@PathParam("userid") Integer userId) throws ApplicationException {
		return reimbursementService.getSpecificRequests(userId);
	}

	// GET ALL OF AN EMPLOYEE'S PENDING REIMBURSEMENTS (EMPLOYEE)
	// http://localhost:8080/api/reimbursements/pending/employee/2 (500)
	@GetMapping("reimbursements/pending/employee/{userid}")
	List<ReimbursementPojo> getPendingRequests(@PathVariable("userid") int userId) throws ApplicationException {
		return reimbursementService.getPendingRequests(userId);

	}

	// GET ALL OF AN EMPLOYEE'S RESOLVED REIMBURSEMENTS (EMPLOYEE)
	// http://localhost:8080/api/reimbursements/resolved/employee/2 (500)
	@GetMapping("reimbursements/resolved/employee/{userid}")
	List<ReimbursementPojo> getResolvedRequests(int userId) throws ApplicationException {
		return reimbursementService.getResolvedRequests(userId);
	}

	// (HARD) DELETE A REIMBURSEMENT
	// http://localhost:8080/api/reimbursements/remove/1 (200 OK)
	@DeleteMapping("reimbursements/remove/{rbid}")
	boolean deleteRequest(@PathVariable("rbid") Integer rbId) throws ApplicationException {
		return reimbursementService.deleteRequest(rbId);

	}

	// ADD A REIMBURSEMENT
	// http://localhost:8080/api/reimbursements/add (200 OK)
	@PostMapping("reimbursements/add")
	ReimbursementPojo submitRequest(@RequestBody ReimbursementPojo reimbursementPojo) throws ApplicationException {
		return reimbursementService.submitRequest(reimbursementPojo);

	}

	// UPDATE A REIMBURSEMENT
	// http://localhost:8080/api/reimbursements/update/2 (200 OK)
	@PutMapping("reimbursements/update/{rbid}")
	ReimbursementPojo updateReimbursement(@RequestBody ReimbursementPojo reimbursementPojo) throws ApplicationException {
		return reimbursementService.updateReimbursement(reimbursementPojo);
	}

	// APPROVE A REIMBURSEMENT
	// http://localhost:8080/api/reimbursements/approve/2 (*** WARNING *** ACTUALLY HARD DELETES ** 200 OK)
	@DeleteMapping("reimbursements/approve/{rbid}")
	boolean manageRequest(@PathVariable("rbid") int rbId) throws ApplicationException {
		return reimbursementService.manageRequest(rbId);

	}

	// DENY A REIMBURSEMENT
	// http://localhost:8080/api/reimbursements/deny/1 (*** WARNING *** ACTUALLY HARD DELETES ** 200 OK)
	@DeleteMapping("reimbursements/deny/{rbid}")
	boolean denyRequest(@PathVariable("rbid") int rbId) throws ApplicationException {
		return reimbursementService.denyRequest(rbId);

	}

	// ________________________________ USER ENDPOINTS _____________________________________

	// ADD A USER
	// http://localhost:8080/api/users/register
	@PostMapping("api/users/register")
	UserPojo register(@RequestBody UserPojo userPojo) throws ApplicationException {
		return userService.register(userPojo);

	}

	// VALIDATE A USER
	// http://localhost:8080/api/users/login
	@GetMapping("users/login/{userid}")
	UserPojo validateUser(@PathVariable("userid") int userId) throws ApplicationException {
		return userService.validateUser(userId);

	}

	// UPDATE A USER
	// http://localhost:8080/api/users/update/1
	@PutMapping("users/update/{userid}")
	UserPojo updateUser(@RequestBody UserPojo userPojo) throws ApplicationException{
		return userService.updateUser(userPojo);

	}

	// GET ALL USERS (EMPLOYEES ONLY)
	// http://localhost:8080/api/users/employees
	@GetMapping("users/employees")
	List<UserPojo> getAllUsers() throws ApplicationException {
		return userService.getAllUsers();

	}

	// (SOFT) DELETE A USER
	// http://localhost:8080/api/users/remove/5
	@DeleteMapping("users/remove/{userid}")
	boolean deleteUser(@PathVariable("userid") int userId) throws ApplicationException {
		return userService.deleteUser(userId);

	}

	// GET A USER (EMPLOYEES ONLY)
	// http://localhost:8080/api/users/employee/1
	@GetMapping("users/employee/{userid}")
	UserPojo getAUser(Integer userId) throws ApplicationException {
		return userService.getAUser(userId);

	}

	// ________________________________ IMAGE ENDPOINTS _____________________________________

	// ADD AN IMAGE
	// http://localhost:8080/api/images/add
	@PostMapping("images/add")
	ImagePojo addImage(@RequestBody ImagePojo imagePojo) throws ApplicationException {
		return imageService.addImage(imagePojo);
	}

	// GET AN IMAGE
	// http://localhost:8080/api/images/1
	@GetMapping("images/{imgid}")
	ImagePojo getAnImage(@PathVariable("imgid") int imgId) throws ApplicationException {
		return imageService.getAnImage(imgId);
	}

	// UPDATE AN IMAGE
	// http://localhost:8080/api/images/update/1
	@PutMapping("images/update/{imgid}")
	ImagePojo updateImage(@RequestBody ImagePojo imagePojo) throws ApplicationException {
		return imageService.updateImage(imagePojo);
	}

	// DELETE AN IMAGE
	// http://localhost:8080/api/images/delete/1
	@DeleteMapping("images/delete/{imgid}")
	boolean deleteImage(@PathVariable("imgid") int imgId) throws ApplicationException {
		return imageService.deleteImage(imgId);

	}

}
