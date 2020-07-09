package com.mindtree.newzz.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.EditorLoginDetails;
import com.mindtree.newzz.exception.EmailAlreadyExistsException;
import com.mindtree.newzz.exception.InvalidCredentialsException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.exception.UserNotRegistered;
import com.mindtree.newzz.repository.EditorLoginDetailsRepository;
import com.mindtree.newzz.repository.EditorRepository;
import com.mindtree.newzz.service.EditorService;
import com.mindtree.newzz.utils.dto.UserLoginDTO;
import com.mindtree.newzz.utils.dto.UserSignupDTO;
import com.mindtree.newzz.utils.encryption.AESEncryption;

@Service
public class EditorServiceImpl implements EditorService {

	@Autowired
	private EditorRepository repo;

	@Autowired
	private EditorLoginDetailsRepository loginRepo;

	@Override
	public Editor addEditor(UserSignupDTO editorDTO) throws ServiceException {

		if (loginRepo.findByEmail(editorDTO.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException(editorDTO.getEmail() + " is already registered");
		}
		editorDTO.setPassword(AESEncryption.encrypt(editorDTO.getPassword()));
		ModelMapper mapper = new ModelMapper();
		Editor editor = mapper.map(editorDTO, Editor.class);
		editor = repo.save(editor);
		EditorLoginDetails details = mapper.map(editorDTO, EditorLoginDetails.class);
		details.setEditor(editor);
		loginRepo.save(details);
		return editor;
	}

	@Override
	public Editor login(UserLoginDTO loginDTO) throws ServiceException {
		loginRepo.findByEmail(loginDTO.getEmail())
				.orElseThrow(() -> new UserNotRegistered(loginDTO.getEmail() + " is not a registered email"));
		Editor editor = loginRepo.findByDetails(loginDTO.getEmail(), AESEncryption.encrypt(loginDTO.getPassword()))
				.orElseThrow(() -> new InvalidCredentialsException("email and password do not match"));

		return editor;
	}


}
