package com.mindtree.newzz.exception;

public class EditorAlreadyApprovedException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9120947394952498007L;

	public EditorAlreadyApprovedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EditorAlreadyApprovedException(String arg0) {
		super(arg0);
	}

}
