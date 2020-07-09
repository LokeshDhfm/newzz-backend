package com.mindtree.newzz.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.newzz.entity.Admin;
import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.exception.EditorAlreadyApprovedException;
import com.mindtree.newzz.exception.NoSuchEditorException;
import com.mindtree.newzz.exception.NoSuchUserException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.repository.AdminRepository;
import com.mindtree.newzz.repository.EditorRepository;
import com.mindtree.newzz.repository.UserRepository;
import com.mindtree.newzz.service.AdminService;
import com.mindtree.newzz.utils.dto.AdminLoginDTO;
import com.mindtree.newzz.utils.dto.AdminSignUpDTO;
import com.mindtree.newzz.utils.encryption.AESEncryption;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repo;

	@Autowired
	private EditorRepository editorRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Editor removeEditor(Long editorId) throws ServiceException {

		Editor editor = editorRepo.findById(editorId)
				.orElseThrow(() -> new NoSuchEditorException("No editor with the id " + editorId + " in database."));

		editorRepo.delete(editor);

		return editor;
	}

	@Override
	public User removeUser(Long userId) throws ServiceException {

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new NoSuchUserException("No user with id " + userId + " in database."));

		userRepo.delete(user);

		return user;
	}

	@Override
	public Admin login(AdminLoginDTO adminLoginDetails) throws ServiceException {

		Admin admin = repo.findByEmail(adminLoginDetails.getEmail())
				.orElseThrow(() -> new ServiceException("Invalid email"));
		if (admin.getPassword().equals(AESEncryption.encrypt(adminLoginDetails.getPassword()))) {
			return admin;
		} else {
			throw new ServiceException("Invalid credentials");
		}
	}

	@Override
	public Admin signup(AdminSignUpDTO adminSignupDetails) throws ServiceException {
		boolean isPresent = repo.findByEmail(adminSignupDetails.getEmail()).isPresent();
		if (isPresent) {
			throw new ServiceException("Invalid email");
		}
		ModelMapper mapper = new ModelMapper();
		Admin admin = mapper.map(adminSignupDetails, Admin.class);
		admin.setPassword(AESEncryption.encrypt(adminSignupDetails.getPassword()));
		System.out.println(admin);
		return repo.save(admin);
	}

	@Override
	public List<Editor> getUnApprovedEditors() throws ServiceException {
		List<Editor> editors = editorRepo.findByIsApprovedFalse();
		if(editors.isEmpty()) throw new ServiceException("no unapproved editors");
		editors.forEach(editor -> System.out.println(editor.getName()+ " "+ editor.getPhone()));
		return editors;
	}

	@Override
	public List<Editor> getApprovedEditors() throws ServiceException {
		List<Editor> editors = editorRepo.findByIsApprovedTrue();
		if(editors.isEmpty()) throw new ServiceException("no approved editors");
		editors.forEach(editor -> System.out.println(editor.getName()+ " "+ editor.getPhone()));
		return editors;
	}

	@Override
	public Editor approveEditor(Long editorId) throws ServiceException {
		Editor editor = editorRepo.findById(editorId).orElseThrow(() -> new NoSuchEditorException("No editor found with id "+ editorId+" in the database"));
		if(editor.isApproved()) {
			throw new EditorAlreadyApprovedException("editor has been already approved");
		}
		editorRepo.approveEditor(editorId);
		editor = editorRepo.findById(editorId).orElseThrow(() -> new NoSuchEditorException("No editor found with id "+ editorId+" in the database"));
		return editor; 
	}

}
