package com.spring.clubAPI.exception;

public class ExcptionsHandler {
	private int statusCode;
	private String message;
	private long time;
	

	public int getStatusCode() {
		return statusCode;
	}



	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public long getTime() {
		return time;
	}



	public void setTime(long time) {
		this.time = time;
	}

	
}
