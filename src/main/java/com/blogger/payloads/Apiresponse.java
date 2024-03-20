package com.blogger.payloads;

public class Apiresponse {

	private String message;
	private boolean success;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Apiresponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	public Apiresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
