package com.mindtree.newzz.utils.dto;

public class CommentEditDTO {

	private Long commentId;

	private Long editorId;

	private Long userId;

	private String comment;

	/**
	 * @return the commentId
	 */
	public Long getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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

	public CommentEditDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentEditDTO(Long commentId, Long editorId, Long userId, String comment) {
		this.commentId = commentId;
		this.editorId = editorId;
		this.userId = userId;
		this.comment = comment;
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

}
