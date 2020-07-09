package com.mindtree.newzz.exception;

public class InvalidCredentialsException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidCredentialsException(String arg0) {
		super(arg0);
	}

}
