package com.mindtree.newzz.exception;

public class NoSuchUserException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchUserException(String arg0) {
		super(arg0);
	}

}
