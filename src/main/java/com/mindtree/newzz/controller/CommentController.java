package com.mindtree.newzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.newzz.entity.Comment;
import com.mindtree.newzz.exception.NewzzException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.service.CommentService;
import com.mindtree.newzz.utils.dto.CommentDTO;
import com.mindtree.newzz.utils.dto.CommentEditDTO;
import com.mindtree.newzz.utils.dto.ResponseDTO;

@RestController
@RequestMapping("comment")
@CrossOrigin
public class CommentController {

	@Autowired
	private CommentService service;

	@PostMapping("add")
	public ResponseEntity<ResponseDTO<Comment>> addCommentToPost(@RequestBody CommentDTO commentDTO)
			throws NewzzException {
		try {
			return new ResponseEntity<ResponseDTO<Comment>>(
					new ResponseDTO<Comment>(service.addComment(commentDTO), null, true), HttpStatus.OK);
		} catch (ServiceException e) {
			throw new NewzzException(e.getMessage());
		}
	}

	@DeleteMapping("delete/{editorId}/{commentId}")
	public ResponseEntity<ResponseDTO<?>> deleteComment(@PathVariable Long editorId, @PathVariable Long commentId)
			throws NewzzException {

		return new ResponseEntity<ResponseDTO<?>>(
				new ResponseDTO<>(service.deleteComment(editorId, commentId), null, true), HttpStatus.OK);

	}
	
	@PutMapping("edit")
	public ResponseEntity<ResponseDTO<?>> editComment(@RequestBody CommentEditDTO commentEditDTO) throws NewzzException {
		return new ResponseEntity<ResponseDTO<?>>(new ResponseDTO<>(service.editComment(commentEditDTO),null,true),HttpStatus.OK);
	}

}
