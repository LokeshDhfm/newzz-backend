package com.mindtree.newzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.newzz.entity.Admin;
import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.exception.NewzzException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.service.AdminService;
import com.mindtree.newzz.utils.dto.AdminLoginDTO;
import com.mindtree.newzz.utils.dto.AdminSignUpDTO;
import com.mindtree.newzz.utils.dto.ResponseDTO;

@RestController
@RequestMapping(value = "admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping("login")
	public ResponseEntity<ResponseDTO<Admin>> login(@RequestBody AdminLoginDTO loginDTO) throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<Admin>>(new ResponseDTO<Admin>(service.login(loginDTO), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	@PostMapping("signup")
	public ResponseEntity<ResponseDTO<Admin>> signup(@RequestBody AdminSignUpDTO signupDTO) throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<Admin>>(new ResponseDTO<Admin>(service.signup(signupDTO), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	@PostMapping("remove/editor/{editorId}")
	public ResponseEntity<ResponseDTO<Editor>> removeEditor(@PathVariable Long editorId) throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<Editor>>(new ResponseDTO<Editor>(service.removeEditor(editorId), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	@PostMapping("remove/user/{userId}")
	public ResponseEntity<ResponseDTO<User>>  removeUser(@PathVariable Long userId) throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<User>>(new ResponseDTO<User>(service.removeUser(userId), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@GetMapping("editor/notapproved")
	public ResponseEntity<ResponseDTO<List<Editor>>> getEditorsNotApproved() throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<List<Editor>>>(new ResponseDTO<List<Editor>>(service.getUnApprovedEditors(), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}
		
	@GetMapping("editor/approved")
	public ResponseEntity<ResponseDTO<List<Editor>>> getEditorsApproved() throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<List<Editor>>>(new ResponseDTO<List<Editor>>(service.getApprovedEditors(), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	@PutMapping("editor/approve")
	public ResponseEntity<ResponseDTO<Editor>> approveEditor(@RequestBody Long editorId) throws NewzzException {
		try {			
			return new ResponseEntity<ResponseDTO<Editor>>(new ResponseDTO<Editor>(service.approveEditor(editorId), null, true),HttpStatus.OK);
		} catch(ServiceException | RuntimeException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
}
