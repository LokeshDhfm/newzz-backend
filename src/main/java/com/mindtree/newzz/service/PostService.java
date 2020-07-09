package com.mindtree.newzz.service;

import java.io.IOException;
import java.util.List;

import com.mindtree.newzz.entity.Post;
import com.mindtree.newzz.entity.Tag;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.utils.dto.PostDTO;
import com.mindtree.newzz.utils.dto.PostDeleteDTO;
import com.mindtree.newzz.utils.dto.PostEditDTO;

public interface PostService {

	public Post addPost(PostDTO postDTO) throws ServiceException, IOException;
	
	public void deletePost(PostDeleteDTO postDeleteDTO) throws ServiceException;

	public Post editPost(PostEditDTO postEditDTO) throws ServiceException;
	
	public List<Post> getAllPostsByEditorId(Long editorId) throws ServiceException;

	public List<Post> getAllPostsByUserFollowedTags(Long userID) throws ServiceException;
	
	public List<Post> getAllPosts() throws ServiceException;
	
	public List<Tag> getAllTags();

	public List<Post> getAllFilteredPosts(List<Tag> tags);
}
