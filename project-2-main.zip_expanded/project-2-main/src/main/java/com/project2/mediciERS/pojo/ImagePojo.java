package com.project2.mediciERS.pojo;

public class ImagePojo {

	private int imgId;
	private int rbId;
	private String imgURL;
	private boolean imgRemoved;

	public ImagePojo() {
		super();
	}

	public ImagePojo(int imgId, int rbId, String imgURL, boolean imgRemoved) {
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
		return "ImagePojo [imgId=" + imgId + ", rbId=" + rbId + ", imgURL=" + imgURL + ", imgRemoved=" + imgRemoved
				+ "]";
	}

	
}
