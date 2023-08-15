package com.kleyber.SISGEO.resources.exceptions;

public class ErroPadrao {

	private Long timestamp;
	private Integer satus;
	private String error;
	private String message;
	private String path;
	public ErroPadrao() {
		super();
	}
	public ErroPadrao(Long timestamp, Integer satus, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.satus = satus;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getSatus() {
		return satus;
	}
	public void setSatus(Integer satus) {
		this.satus = satus;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
