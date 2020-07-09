package com.mindtree.newzz.utils.dto;

public class CommentDTO {

	private Long postId;

	private Long userId;

	private String comment;

	private Long editorId;

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

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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

	public CommentDTO(Long postId, Long userId, String comment, Long editorId) {
		this.postId = postId;
		this.userId = userId;
		this.comment = comment;
		this.editorId = editorId;
	}

	public CommentDTO() {
		super();
	}

}
