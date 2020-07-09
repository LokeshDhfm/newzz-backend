package com.mindtree.newzz.utils.dto;

import java.util.Date;

public class ResponseDTO<T> {
	
	private Date date;
	
	private T  response;
	
	private ErrorDTO error;
	
	private boolean isSuccess;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the response
	 */
	public T getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(T response) {
		this.response = response;
	}

	/**
	 * @return the error
	 */
	public ErrorDTO getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(ErrorDTO error) {
		this.error = error;
	}
	
	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public ResponseDTO(T response, ErrorDTO error, boolean isSuccess) {
		this.date = new Date();
		this.response = response;
		this.error = error;
		this.isSuccess = isSuccess;
	}

	public ResponseDTO() {
		super();
	}

	
	
	
	
	
}
