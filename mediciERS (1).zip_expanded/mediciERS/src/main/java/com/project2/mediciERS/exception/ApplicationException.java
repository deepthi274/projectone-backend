package com.project2.mediciERS.exception;

public class ApplicationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	public ApplicationException(String msg) {
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return this.msg;
	}
}
