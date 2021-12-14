package com.project2.mediciERS.service;

import org.springframework.web.multipart.MultipartFile;

import com.project2.mediciERS.exception.ApplicationException;
import com.project2.mediciERS.pojo.ImagePojo;

public interface ImageService {
	
	ImagePojo addImage(ImagePojo imagePojo) throws ApplicationException;
	ImagePojo updateImage(ImagePojo imagePojo) throws ApplicationException;
	boolean deleteImage(int imgId) throws ApplicationException;
	void  saveImageToDB(MultipartFile file,int userId);
		
	// MANAGER
	ImagePojo getAnImage(int imgId) throws ApplicationException;
			

			

}