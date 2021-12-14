package com.project2.mediciERS.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project2.mediciERS.dao.ImageRepositoryDao;
import com.project2.mediciERS.entity.Image;
import com.project2.mediciERS.entity.Reimbursement;
import com.project2.mediciERS.exception.ApplicationException;
import com.project2.mediciERS.pojo.ImagePojo;
import com.project2.mediciERS.pojo.ReimbursementPojo;

@Service
public class ImageServiceImpl implements ImageService {

	public static final Logger logger = LogManager.getLogger(ImageServiceImpl.class);

	@Autowired
	ImageRepositoryDao imageRepositoryDao;

	public ImageServiceImpl() {

	}

	// SAVE IMAGE TO DATABASE
	@Override
	public void saveImageToDB(MultipartFile file, int userId) {
		logger.info("Entered saveImageToDB() in service.");
		Image p = new Image();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
		}
		try {
			p.setImgURL(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setUserId(userId);

		imageRepositoryDao.save(p);
		logger.info("Exited saveImageToDB() in service.");
	}

	// ADD AN IMAGE
	@Override
	public ImagePojo addImage(ImagePojo imagePojo) throws ApplicationException {
		logger.info("Entered addImage() in service.");
		Image newImage = new Image(imagePojo.getImgId(), imagePojo.getRbId(), imagePojo.getImgURL(),
				imagePojo.isImgRemoved(), imagePojo.getUserId());
		Image returnImage = imageRepositoryDao.saveAndFlush(newImage);
		imagePojo.setRbId(returnImage.getRbId());
		logger.info("Exited addImage() in service.");
		return imagePojo;
	}

	// GET AN IMAGE
	@Override
	public ImagePojo getAnImage(int imgId) throws ApplicationException {
		logger.info("Entered getAnImage() in service.");
		ImagePojo imagePojo = null;
		Optional<Image> optional = this.imageRepositoryDao.findById(imgId);
		if (optional.isPresent()) {
			Image image = optional.get();
			imagePojo = new ImagePojo(image.getImgId(), image.getRbId(), image.getImgURL(), image.isImgRemoved(),
					image.getUserId());
		}
		logger.info("Exited getAnImage() in service.");
		return imagePojo;
	}

	// UPDATE AN IMAGE
	@Override
	public ImagePojo updateImage(ImagePojo imagePojo) throws ApplicationException {
		logger.info("Entered updateImage() in service.");
		Image updateImage = new Image(imagePojo.getImgId(), imagePojo.getRbId(), imagePojo.getImgURL(),
				imagePojo.isImgRemoved(), imagePojo.getUserId());
		Image returnImage = imageRepositoryDao.save(updateImage);
		logger.info("Exited updateImage() in service.");
		return imagePojo;
	}

	// DELETE AN IMAGE
	@Override
	public boolean deleteImage(int imgId) throws ApplicationException {
		logger.info("Entered deleteImage() in service.");
		this.imageRepositoryDao.deleteById(imgId); // deleteByRbId
		logger.info("Exited deleteImage() in service.");
		return true;
	}

}