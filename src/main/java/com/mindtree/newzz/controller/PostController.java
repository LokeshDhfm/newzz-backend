package com.mindtree.newzz.controller;

import java.io.IOException;
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

import com.mindtree.newzz.entity.Post;
import com.mindtree.newzz.entity.Tag;
import com.mindtree.newzz.exception.NewzzException;
import com.mindtree.newzz.service.PostService;
import com.mindtree.newzz.utils.dto.PostDTO;
import com.mindtree.newzz.utils.dto.PostDeleteDTO;
import com.mindtree.newzz.utils.dto.PostEditDTO;
import com.mindtree.newzz.utils.dto.ResponseDTO;

@RequestMapping("post")
@RestController
@CrossOrigin
public class PostController {

	@Autowired
	private PostService service;

	@PostMapping(value = "add")
	public ResponseEntity<ResponseDTO<Post>> addPost(@RequestBody PostDTO postDTO) throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<Post>>(new ResponseDTO<Post>(service.addPost(postDTO), null, true),
					HttpStatus.OK);
		} catch (RuntimeException | NewzzException | IOException e) {
			throw new NewzzException(e.getMessage());
		}

	}

	@PutMapping(value = "delete")
	public ResponseEntity<ResponseDTO<?>> deletePost(@RequestBody PostDeleteDTO postDeleteDTO) throws NewzzException {
		service.deletePost(postDeleteDTO);
		try {
			return new ResponseEntity<ResponseDTO<?>>(new ResponseDTO<>("Successfully deleted the post", null, true),
					HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}

	}

	@PutMapping(value = "edit")
	public ResponseEntity<ResponseDTO<?>> editPost(@RequestBody PostEditDTO postEditDTO) throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<?>>(new ResponseDTO<>(service.editPost(postEditDTO), null, true),
					HttpStatus.ACCEPTED);
		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}

	}

//	@PutMapping(value = "update")
//	public Post updatePost(@RequestBody PostEditDTO postEditDTO) throws NewzzException {
//		return service.editPost(postEditDTO);
//	}

	@GetMapping("editor/{editorId}")
	public ResponseEntity<ResponseDTO<List<Post>>> getAllPostsByEditorId(@PathVariable Long editorId)
			throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<List<Post>>>(
					new ResponseDTO<>(service.getAllPostsByEditorId(editorId), null, true), HttpStatus.OK);

		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}

	}

	@GetMapping("user/{userId}/tags")
	public ResponseEntity<ResponseDTO<List<Post>>> getAllPostWithUserFollowedTags(@PathVariable Long userId)
			throws NewzzException {

		try {
			return new ResponseEntity<ResponseDTO<List<Post>>>(
					new ResponseDTO<>(service.getAllPostsByUserFollowedTags(userId), null, true), HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}
	}

	@GetMapping("")
	public ResponseEntity<ResponseDTO<List<Post>>> getAllPosts() throws NewzzException {

		try {
			return new ResponseEntity<ResponseDTO<List<Post>>>(new ResponseDTO<>(service.getAllPosts(), null, true),
					HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}

	}
	
	@GetMapping("tags")
	public ResponseEntity<ResponseDTO<List<Tag>>> getTags() throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<List<Tag>>>(new ResponseDTO<>(service.getAllTags(), null, true),
					HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}
	}

	@PostMapping("filter")
	ResponseEntity<ResponseDTO<List<Post>>> getAllFilteredPosts(@RequestBody List<Tag> tags) throws NewzzException {

		try {
			return new ResponseEntity<ResponseDTO<List<Post>>>(new ResponseDTO<>(service.getAllFilteredPosts(tags), null, true),
					HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new NewzzException(e.getMessage());
		}

	} 
}
