package com.project2.mediciERS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.mediciERS.entity.Image;


@Repository
public interface ImageRepositoryDao extends JpaRepository<Image, Integer> {
	
	// ______________________________ FINDER METHODS ______________________________________
	
	List<Image> findByImgId(int imgId);
	List<Image> findByRbId(int rbId);
	List<Image> findByUserId(int userId);
	

}
