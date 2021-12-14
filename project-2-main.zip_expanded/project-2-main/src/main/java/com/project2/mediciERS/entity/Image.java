package com.project2.mediciERS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image_details")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "img_id")
	private int imgId;

	@Column(name = "rb_id")
	private int rbId;

	@Column(name = "img_url")
	private String imgURL;

	@Column(name = "img_removed")
	private boolean imgRemoved;

	public Image() {
		super();
	}

	public Image(int imgId, int rbId, String imgURL, boolean imgRemoved) {
		super();
		this.imgId = imgId;
		this.rbId = rbId;
		this.imgURL = imgURL;
		this.imgRemoved = imgRemoved;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public int getRbId() {
		return rbId;
	}

	public void setRbId(int rbId) {
		this.rbId = rbId;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public boolean isImgRemoved() {
		return imgRemoved;
	}

	public void setImgRemoved(boolean imgRemoved) {
		this.imgRemoved = imgRemoved;
	}

	@Override
	public String toString() {
		return "Image [imgId=" + imgId + ", rbId=" + rbId + ", imgURL=" + imgURL + ", imgRemoved=" + imgRemoved + "]";
	}

}
