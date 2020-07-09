package com.mindtree.newzz.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Editor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5887068765152770159L;

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Column(updatable = true)
	private String name;

	private Date dateOfBirth;
	
	private Long phone;

	@OneToMany(mappedBy = "editor", targetEntity = Post.class)
	private List<Post> posts = new ArrayList<Post>();

	@OneToMany(mappedBy = "editor", targetEntity = Comment.class)
	private List<Comment> comments = new ArrayList<Comment>();
	
	private boolean isApproved;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	

	public Editor() {
		super();
	}

	@Override
	public String toString() {
		return "Editor [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
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
		Editor other = (Editor) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Editor(Long id, @NotEmpty String name, Date dateOfBirth, Long phone, boolean isApproved) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.isApproved = isApproved;
	}

}
