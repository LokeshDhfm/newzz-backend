package com.mindtree.newzz.utils.dto;

import java.util.ArrayList;
import java.util.List;

public class PostDTO {

	private String title;

	private String shortDescription;

	private String story;

	private Long editorId;

	private List<String> tags = new ArrayList<String>();

//	private MultipartFile file;
	
	
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
		return editorId;
	}

	/**
	 * @param editorId the editorId to set
	 */
	public void setEditorId(Long editorId) {
		this.editorId = editorId;
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

	public PostDTO(String title, String shortDescription, String story, Long editorId, List<String> tags) {
		this.title = title;
		this.shortDescription = shortDescription;
		this.story = story;
		this.editorId = editorId;
		this.tags = tags;
	}

	public PostDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PostDTO [title=" + title + ", shortDescription=" + shortDescription + ", story=" + story + ", editorId="
				+ editorId + ", tags=" + tags + "]";
	}

//	/**
//	 * @return the file
//	 */
//	public MultipartFile getFile() {
//		return file;
//	}
//
//	/**
//	 * @param file the file to set
//	 */
//	public void setFile(MultipartFile file) {
//		this.file = file;
//	}

}
