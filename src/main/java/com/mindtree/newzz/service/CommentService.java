package com.mindtree.newzz.service;

import com.mindtree.newzz.entity.Comment;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.utils.dto.CommentDTO;
import com.mindtree.newzz.utils.dto.CommentEditDTO;

public interface CommentService {

	public Comment addComment(CommentDTO commentDTO) throws ServiceException;

	public Comment deleteComment(Long editorId, Long commentId) throws ServiceException;

	public Comment editComment(CommentEditDTO commentEditDTO) throws ServiceException;
}
