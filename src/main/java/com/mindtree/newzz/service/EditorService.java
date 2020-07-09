package com.mindtree.newzz.service;

import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.utils.dto.UserLoginDTO;
import com.mindtree.newzz.utils.dto.UserSignupDTO;

public interface EditorService {

	public Editor addEditor(UserSignupDTO editorDTO) throws ServiceException;

	public Editor login(UserLoginDTO loginDTO) throws ServiceException;

}
