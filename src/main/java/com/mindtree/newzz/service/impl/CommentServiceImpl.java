package com.mindtree.newzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.newzz.entity.Comment;
import com.mindtree.newzz.exception.NoSuchCommentExistsException;
import com.mindtree.newzz.exception.NoSuchEditorException;
import com.mindtree.newzz.exception.NoSuchPostException;
import com.mindtree.newzz.exception.NoSuchUserException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.repository.CommentRepository;
import com.mindtree.newzz.repository.EditorRepository;
import com.mindtree.newzz.repository.PostRepository;
import com.mindtree.newzz.repository.UserRepository;
import com.mindtree.newzz.service.CommentService;
import com.mindtree.newzz.utils.dto.CommentDTO;
import com.mindtree.newzz.utils.dto.CommentEditDTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository repo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EditorRepository editorRepo;

	@Autowired
	private PostRepository postRepo;

	@Override
	public Comment addComment(CommentDTO commentDTO) throws ServiceException {

		Comment comment = new Comment();

		comment.setComment(commentDTO.getComment());

		comment.setEditor(editorRepo.findById(commentDTO.getEditorId())
				.orElseThrow(() -> new NoSuchEditorException("No such editor with id " + commentDTO.getEditorId())));

		comment.setPost(postRepo.findById(commentDTO.getPostId())
				.orElseThrow(() -> new NoSuchPostException("No post with id " + commentDTO.getPostId())));
		if(commentDTO.getUserId()!=null)
			comment.setUser(userRepo.findById(commentDTO.getUserId())
				.orElseThrow(() -> new NoSuchUserException("No user exists with id " + commentDTO.getUserId())));
		else {
			comment.setUser(null);
		}
		return repo.save(comment);
	}

	@Override
	public Comment deleteComment(Long editorId, Long commentId) throws ServiceException {

		Comment comment = repo.findById(commentId)
				.orElseThrow(() -> new NoSuchCommentExistsException("No comment with the id " + commentId));

		if (comment.getEditor().getId() != editorId) {
			throw new ServiceException("Editor not related to the comment, check the editor id.");
		}
		repo.delete(comment);
		return comment;
	}

	@Override
	public Comment editComment(CommentEditDTO commentEditDTO) throws ServiceException {
		Comment comment = repo.findById(commentEditDTO.getCommentId()).orElseThrow(
				() -> new NoSuchCommentExistsException("No comment with the id " + commentEditDTO.getCommentId()));

		if (comment.getEditor().getId() != commentEditDTO.getEditorId()) {
			throw new ServiceException("Editor not related to the comment, check the editor id.");
		}

		if (commentEditDTO.getUserId() != null && comment.getUser().getId() != commentEditDTO.getUserId()) {
			throw new ServiceException("User not related to comment");
		}
		comment.setComment(commentEditDTO.getComment());
		return repo.save(comment);
	}

}
