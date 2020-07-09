package com.mindtree.newzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.exception.NewzzException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.service.EditorService;
import com.mindtree.newzz.utils.dto.ResponseDTO;
import com.mindtree.newzz.utils.dto.UserLoginDTO;
import com.mindtree.newzz.utils.dto.UserSignupDTO;

@RequestMapping("editor")
@RestController
@CrossOrigin
public class EditorController {

	@Autowired
	private EditorService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "signup")
	public ResponseEntity<ResponseDTO<Editor>> addUser(@RequestBody UserSignupDTO signupDTO) throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<Editor>>(new ResponseDTO<Editor>(service.addEditor(signupDTO), null, true),
					HttpStatus.OK);
		} catch (ServiceException e) {
			throw new NewzzException(e.getMessage(), e);
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO<Editor>> login(@RequestBody UserLoginDTO loginDTO) throws NewzzException {
		try {

			return new ResponseEntity<ResponseDTO<Editor>>(new ResponseDTO<Editor>(service.login(loginDTO), null, true),
					HttpStatus.OK);

		} catch (ServiceException e) {
			throw new NewzzException(e.getMessage(), e);
		}
	}
	
}
