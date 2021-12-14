package com.project2.mediciERS.service;

import java.util.List;

import com.project2.mediciERS.entity.Reimbursement;
import com.project2.mediciERS.exception.ApplicationException;
import com.project2.mediciERS.pojo.ReimbursementPojo;

public interface ReimbursementService {
	
	// MANAGER
	List<ReimbursementPojo> getAllPendingRequests(String rbStatus) throws ApplicationException; // VIEW ALL PENDING REQUESTS ***
	List<ReimbursementPojo> getAllResolvedRequests(boolean rbRemoved) throws ApplicationException; // VIEW ALL RESOLVED REQUESTS ***
	List<ReimbursementPojo> getSpecificRequests(Integer userId) throws ApplicationException; // VIEW ALL OF AN EMPLOYEE'S REQUEST ***
	boolean manageRequest(int rbId) throws ApplicationException; // APPROVE A REQUEST ***
	boolean denyRequest(int rbId) throws ApplicationException; // DENY A REQUEST ***
	boolean deleteRequest(Integer rbId) throws ApplicationException; // DELETE A REQUEST ***
			
	// EMPLOYEE
	ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException; // ADD A REIMBURSEMENT REQUEST ***
	List<ReimbursementPojo> getPendingRequests(int userId) throws ApplicationException; // VIEW ALL PENDING REQUESTS (EMPLOYEE) ***
	List<ReimbursementPojo> getResolvedRequests(int userId) throws ApplicationException; // VIEW ALL RESOLVED REQUESTS (EMPLOYEE) ***
	ReimbursementPojo updateReimbursement(ReimbursementPojo reimbursementPojo) throws ApplicationException; // UPDATE REIMBURSEMENT ***
	ReimbursementPojo getAReimbursement(int rbId) throws ApplicationException;
	
	
	void exitApplication();

}
