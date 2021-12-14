package com.project2.mediciERS.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.mediciERS.dao.ImageRepositoryDao;
import com.project2.mediciERS.exception.ApplicationException;
import com.project2.mediciERS.pojo.ImagePojo;

@Service
public class ImageServiceImpl implements ImageService {
	
	public static final Logger logger = LogManager.getLogger(ImageServiceImpl.class);
	
	@Autowired
	ImageRepositoryDao imageRepositoryDao;
	
	public ImageServiceImpl() {
		
	}
	
	// ADD AN IMAGE
	@Override
	public ImagePojo addImage(ImagePojo imagePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// GET AN IMAGE
	@Override
	public ImagePojo getAnImage(int imgId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// UPDATE AN IMAGE
	@Override
	public ImagePojo updateImage(ImagePojo imagePojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// DELETE AN IMAGE
	@Override
	public boolean deleteImage(int imgId) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

}
