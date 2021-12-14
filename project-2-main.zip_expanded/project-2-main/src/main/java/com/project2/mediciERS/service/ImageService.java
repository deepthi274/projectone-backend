package com.project2.mediciERS.service;

import com.project2.mediciERS.exception.ApplicationException;
import com.project2.mediciERS.pojo.ImagePojo;

public interface ImageService {
	
	// EMPLOYEE
	ImagePojo addImage(ImagePojo imagePojo) throws ApplicationException;
	ImagePojo updateImage(ImagePojo imagePojo) throws ApplicationException;
	boolean deleteImage(int imgId) throws ApplicationException;
		
	// MANAGER
	ImagePojo getAnImage(int imgId) throws ApplicationException;
			

}
