package com.mindtree.newzz.service;

import java.util.List;

import com.mindtree.newzz.entity.Admin;
import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.utils.dto.AdminLoginDTO;
import com.mindtree.newzz.utils.dto.AdminSignUpDTO;

public interface AdminService {

	public Editor removeEditor(Long editorId) throws ServiceException;

	public User removeUser(Long userId) throws ServiceException;
	
	public Admin login(AdminLoginDTO adminLoginDetails) throws ServiceException;

	public Admin signup(AdminSignUpDTO adminSignupDetails) throws ServiceException;

	public List<Editor> getUnApprovedEditors() throws ServiceException;

	public List<Editor> getApprovedEditors() throws ServiceException;
	
	public Editor approveEditor(Long editorId) throws ServiceException;
}
