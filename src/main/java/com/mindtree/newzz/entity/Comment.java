package com.mindtree.newzz.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4733181984115942929L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@OneToOne
	@JsonIgnoreProperties(value = {"comments"})
	private Post post;

	@OneToOne
	@JsonIgnoreProperties(value = {"comments","followingTags"})
	private User user;

	@NotEmpty
	@Column(length = 300)
	@Size(min = 1, max = 300, message = "Comment cannot be more that 300 or empty")
	private String comment;

	@NotNull
	@OneToOne
	@JsonIgnoreProperties(value = {"posts","comments"})
	private Editor editor;

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
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @return the editor
	 */
	public Editor getEditor() {
		return editor;
	}

	/**
	 * @param editor the editor to set
	 */
	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Comment(Long id, @NotNull Post post, @NotNull User user, @NotEmpty String comment, Editor editor) {
		this.id = id;
		this.post = post;
		this.user = user;
		this.comment = comment;
		this.editor = editor;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}

}
