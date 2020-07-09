package com.mindtree.newzz.utils.dto;

public class PostDeleteDTO {

	private Long editorId;
	
	private Long postId;

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
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public PostDeleteDTO(Long editorId, Long postId) {
		this.editorId = editorId;
		this.postId = postId;
	}

	public PostDeleteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
