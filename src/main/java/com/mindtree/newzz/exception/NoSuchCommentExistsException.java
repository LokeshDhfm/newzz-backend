package com.mindtree.newzz.exception;

public class NoSuchCommentExistsException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCommentExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchCommentExistsException(String arg0) {
		super(arg0);
	}

}
