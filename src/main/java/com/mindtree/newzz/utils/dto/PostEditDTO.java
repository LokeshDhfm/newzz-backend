package com.mindtree.newzz.utils.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

public class PostEditDTO {

	private Long id;

	@Size(min = 7, max = 30, message = "Title cannot be <7 or >30")
	private String title;

	@Size(min = 10, max = 100, message = "Short description cannot be more than 100 characters or less than 10 characters")
	private String shortDescription;

	@Size(min = 30, max = 1000, message = "Story length cannot be more than 1000 characters or less than 30 characters")
	private String story;
	
	private Long EditorId;
	
	private List<String> tags = new ArrayList<String>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * @return the story
	 */
	public String getStory() {
		return story;
	}

	/**
	 * @param story the story to set
	 */
	public void setStory(String story) {
		this.story = story;
	}

	/**
	 * @return the editorId
	 */
	public Long getEditorId() {
		return EditorId;
	}

	/**
	 * @param editorId the editorId to set
	 */
	public void setEditorId(Long editorId) {
		EditorId = editorId;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public PostEditDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostEditDTO(Long id, @Size(min = 7, max = 30, message = "Title cannot be <7 or >30") String title,
			@Size(min = 10, max = 100, message = "Short description cannot be more than 100 characters or less than 10 characters") String shortDescription,
			@Size(min = 30, max = 1000, message = "Story length cannot be more than 1000 characters or less than 30 characters") String story,
			Long editorId, List<String> tags) {
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.story = story;
		EditorId = editorId;
		this.tags = tags;
	}
	
	
	
	
	
}
