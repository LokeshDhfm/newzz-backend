package com.mindtree.newzz.service;

import java.util.List;

import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.utils.dto.UserLoginDTO;
import com.mindtree.newzz.utils.dto.UserSignupDTO;

public interface UserService {

	public User addUser(UserSignupDTO userDTO) throws ServiceException;
	
	public User login(UserLoginDTO loginDTO) throws ServiceException;
	
	public User addFollowingTagsForUser(Long UserId, List<String> tags) throws ServiceException;

}
