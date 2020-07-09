package com.mindtree.newzz.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.newzz.entity.Tag;
import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.entity.UserLoginDetails;
import com.mindtree.newzz.exception.EmailAlreadyExistsException;
import com.mindtree.newzz.exception.InvalidCredentialsException;
import com.mindtree.newzz.exception.NoSuchUserException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.exception.UserNotRegistered;
import com.mindtree.newzz.repository.LoginDetailsRepository;
import com.mindtree.newzz.repository.TagRepository;
import com.mindtree.newzz.repository.UserRepository;
import com.mindtree.newzz.service.UserService;
import com.mindtree.newzz.utils.dto.UserLoginDTO;
import com.mindtree.newzz.utils.dto.UserSignupDTO;
import com.mindtree.newzz.utils.encryption.AESEncryption;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private LoginDetailsRepository loginRepo;
	
	@Autowired
	private TagRepository tagRepo;

	@Override
	public User addUser(UserSignupDTO userDTO) throws ServiceException {

		if (loginRepo.findByEmail(userDTO.getEmail()).isPresent()) {
			throw new EmailAlreadyExistsException(userDTO.getEmail() + " is already registered");
		}
		userDTO.setPassword(AESEncryption.encrypt(userDTO.getPassword()));
		ModelMapper mapper = new ModelMapper();
		User user = mapper.map(userDTO, User.class);
		user = repo.save(user);
		UserLoginDetails details = mapper.map(userDTO, UserLoginDetails.class);
		details.setUser(user);
		loginRepo.save(details);
		return user;
	}

	@Override
	public User login(UserLoginDTO loginDTO) throws ServiceException {

		loginRepo.findByEmail(loginDTO.getEmail())
				.orElseThrow(() -> new UserNotRegistered(loginDTO.getEmail() + " is not a registered email"));
		User user = loginRepo.findByDetails(loginDTO.getEmail(), AESEncryption.encrypt(loginDTO.getPassword()))
				.orElseThrow(() -> new InvalidCredentialsException("email and password do not match"));

		return user;
	}

	@Override
	public User addFollowingTagsForUser(Long UserId, List<String> tagNames) throws ServiceException {
		User user = repo.findById(UserId).orElseThrow(() -> new NoSuchUserException("No user found with id "+ UserId+" in database"));
		List<Tag> tags = user.getFollowingTags();
		tagNames.forEach(tagName -> {
			Tag tag;
			if(!tagRepo.isExists(tagName)) {
				tag = tagRepo.save(new Tag(0L, tagName));
			}
			else {
				tag = tagRepo.findByName(tagName);
			}
			if(!tags.contains(tag)) {
				tags.add(tag);
			}
		});
		user.setFollowingTags(tags);
		return repo.save(user);
	}


}