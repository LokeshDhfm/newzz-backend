package com.mindtree.newzz.exception;

public class NoSuchPostException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchPostException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchPostException(String arg0) {
		super(arg0);
	}

}
