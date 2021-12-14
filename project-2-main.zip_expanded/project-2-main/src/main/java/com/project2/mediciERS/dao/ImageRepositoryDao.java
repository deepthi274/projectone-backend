package com.project2.mediciERS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.mediciERS.entity.Image;


@Repository
public interface ImageRepositoryDao extends JpaRepository<Image, Integer> {
	
	// ______________________________ FINDER METHODS ______________________________________
	

}
