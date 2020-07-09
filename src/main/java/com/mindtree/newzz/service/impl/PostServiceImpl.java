package com.mindtree.newzz.service.impl;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.newzz.entity.Editor;
import com.mindtree.newzz.entity.Post;
import com.mindtree.newzz.entity.Tag;
import com.mindtree.newzz.entity.User;
import com.mindtree.newzz.exception.NoPostsByTheEditorException;
import com.mindtree.newzz.exception.NoSuchEditorException;
import com.mindtree.newzz.exception.NoSuchPostException;
import com.mindtree.newzz.exception.NoSuchUserException;
import com.mindtree.newzz.exception.ServiceException;
import com.mindtree.newzz.repository.EditorRepository;
import com.mindtree.newzz.repository.PostRepository;
import com.mindtree.newzz.repository.TagRepository;
import com.mindtree.newzz.repository.UserRepository;
import com.mindtree.newzz.service.PostService;
import com.mindtree.newzz.utils.dto.PostDTO;
import com.mindtree.newzz.utils.dto.PostDeleteDTO;
import com.mindtree.newzz.utils.dto.PostEditDTO;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repo;

	@Autowired
	private EditorRepository editorRepo;

	@Autowired
	private TagRepository tagRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Post addPost(PostDTO postDTO) throws ServiceException, IOException {
		Editor editor = editorRepo.findById(postDTO.getEditorId())
				.orElseThrow(() -> new NoSuchEditorException("No such editor registered, check the editor id"));
		List<Tag> tags = new ArrayList<Tag>();
//		ModelMapper mapper = new ModelMapper();
		postDTO.getTags().forEach(tagName -> {
			Tag tag = new Tag();
			if (!tagRepo.isExists(tagName)) {
				tag = tagRepo.save(new Tag(0L, tagName));
				System.out.println(tag);
			} else {
				tag = tagRepo.findByName(tagName);
				System.out.println("found" + tag.getId() + tag.getName());
			}
			save(tags, tag);
		});
//		Post post = mapper.map(postDTO, Post.class);
//		Byte[] byteObjects = new Byte[postDTO.getFile().getBytes().length];
//        int i = 0;
//        for (byte b : postDTO.getFile().getBytes()){
//            byteObjects[i++] = b;
//        }
//		
		Post post = new Post();
//		post.setImage(byteObjects);
		post.setTitle(postDTO.getTitle());
		post.setShortDescription(postDTO.getShortDescription());
		post.setStory(postDTO.getStory());
		post.setDate(new Date(System.currentTimeMillis()));
		post.setEditor(editor);
		post.setTags(tags);
		post.getTags().forEach(tag -> {
			System.out.println(tag.getId() + " " + tag.getName());
		});
		post = repo.save(post);
		return post;
	}

	private void save(List<Tag> tags, Tag tag) {
		tags.add(tag);
	}

	@Override
	public void deletePost(PostDeleteDTO postDeleteDTO) throws ServiceException, RuntimeException {
		editorRepo.findById(postDeleteDTO.getEditorId())
				.orElseThrow(() -> new NoSuchEditorException("No such editor registered, check the editor id"));

		Post post = repo.findById(postDeleteDTO.getPostId()).orElseThrow(() -> new NoSuchPostException(
				"No post with this id present in the database, might be it was deleted earlier"));

		if (post.getEditor().getId() != postDeleteDTO.getEditorId()) {
			throw new ServiceException("No previlages to delete the post, contact " + post.getEditor().getName()
					+ ", incase if you insist to remove this post");
		}
		repo.deleteCommentsByPostId(post.getId());
		repo.delete(post);
	}

	@Override
	public Post editPost(PostEditDTO postEditDTO) throws ServiceException {

		Editor editor = editorRepo.findById(postEditDTO.getEditorId())
				.orElseThrow(() -> new NoSuchEditorException("No such editor registered, check the editor id"));

		Post post = repo.findById(postEditDTO.getId()).orElseThrow(() -> new NoSuchPostException(
				"No post with this id present in the database, might be it was deleted earlier"));

		if (post.getEditor().getId() != postEditDTO.getEditorId()) {
			throw new ServiceException("No previlages to edit the post, contact " + post.getEditor().getName()
					+ ", incase if you insist to edit this post");
		}
		ModelMapper mapper = new ModelMapper();
		mapper.map(postEditDTO, post);
		List<Tag> tags = new ArrayList<Tag>();
		postEditDTO.getTags().forEach(tagName -> {
			Tag tag = new Tag();
			if (!tagRepo.isExists(tagName)) {
				tag.setName(tagName);
				tag = tagRepo.save(tag);
				System.out.println("doesn't exists " + tag.getName() + " " + tag.getId());

			} else {
				tag = tagRepo.findByName(tagName);
				System.out.println("already exists" + tagName);
			}
			save(tags, tag);
		});
		post.setEditor(editor);
		return repo.save(post);
	}

	@Override
	public List<Post> getAllPostsByEditorId(Long editorId) throws ServiceException {

		Editor editor = editorRepo.findById(editorId)
				.orElseThrow(() -> new NoSuchEditorException("No such editor registered, check the editor id"));

		List<Post> posts = repo.findByEditor(editor);
		if (posts.isEmpty()) {
			throw new NoPostsByTheEditorException("Editor has not posted anything till date");
		}
		return posts;
	}

	@Override
	public List<Post> getAllPostsByUserFollowedTags(Long userID) throws ServiceException {

		User user = userRepo.findById(userID)
				.orElseThrow(() -> new NoSuchUserException("No user with id " + userID + " is found in database"));

		List<Tag> tags = user.getFollowingTags();

		if (tags.isEmpty()) {
			throw new ServiceException("No tags followed by the user");
		}

		List<Post> posts = repo.findAll();

		posts = posts.stream().filter(post -> {
			for (Tag tag : post.getTags()) {
				if (tags.contains(tag))
					return true;
			}
			return false;

		}).collect(Collectors.toList());

		return posts;

	}

	@Override
	public List<Post> getAllPosts() throws ServiceException {
		List<Post> posts = repo.findAll();
		if (posts.isEmpty())
			throw new NoSuchPostException("No posts in the database");
		return posts;
	}

	@Override
	public List<Tag> getAllTags() {
		return tagRepo.findAll();
	}

	@Override
	public List<Post> getAllFilteredPosts(List<Tag> tags) {
		List<Post> posts = repo.findAll();
		posts = posts.stream().filter(post -> {
			for (Tag tag : post.getTags()) {
				if (tags.contains(tag))
					return true;
			}
			return false;

		}).collect(Collectors.toList());
		return posts;
	}

}
