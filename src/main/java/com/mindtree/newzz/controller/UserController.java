package com.mindtree.newzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.exception.NewzzException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.service.UserService;
import com.mindtree.newzz.utils.dto.ResponseDTO;
import com.mindtree.newzz.utils.dto.UserLoginDTO;
import com.mindtree.newzz.utils.dto.UserSignupDTO;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST, value = "signup")
	public ResponseEntity<ResponseDTO<User>> addUser(@RequestBody UserSignupDTO signupDTO) throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<User>>(new ResponseDTO<User>(service.addUser(signupDTO), null, true),
					HttpStatus.OK);
		} catch (ServiceException | RuntimeException e) {
			throw new NewzzException(e.getMessage(), e);
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO<User>> login(@RequestBody UserLoginDTO loginDTO) throws NewzzException {
		try {

			return new ResponseEntity<ResponseDTO<User>>(new ResponseDTO<User>(service.login(loginDTO), null, true),
					HttpStatus.OK);

		} catch (ServiceException | RuntimeException e) {
			throw new NewzzException(e.getMessage(), e);
		}
	}

	@PutMapping(value = "addTags/{UserId}")
	public ResponseEntity<ResponseDTO<User>> login(@PathVariable Long UserId, @RequestBody List<String> tagNames)
			throws NewzzException {
		try {

			return new ResponseEntity<ResponseDTO<User>>(new ResponseDTO<User>(service.addFollowingTagsForUser(UserId, tagNames), null, true),
					HttpStatus.OK);

		} catch (ServiceException | RuntimeException e) {
			throw new NewzzException(e.getMessage(), e);
		}
	}

}