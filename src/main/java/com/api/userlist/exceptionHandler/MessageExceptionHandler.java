package com.api.userlist.exceptionHandler;

import java.util.Date;

public class MessageExceptionHandler {
	
	private Date timesStamp;
	private Integer status;
	private String message;
	
	public MessageExceptionHandler(Date timestamp, Integer status, String message) {
		this.timesStamp = timestamp;
		this.status = status;
		this.message = message;
	}

	public Date getTimesStamp() {
		return timesStamp;
	}

	public void setTimesStamp(Date timesStamp) {
		this.timesStamp = timesStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
