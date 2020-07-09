package com.mindtree.newzz.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity(name = "user_details")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5207044324706028349L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String name;

	private Date dateOfBirth;

	private Long phone;

	@OneToMany(mappedBy = "user", targetEntity = Comment.class)
	private List<Comment> comments = new ArrayList<Comment>();

//	@ElementCollection
	@ManyToMany
//	(mappedBy = "users", targetEntity = Tag.class)
	private List<Tag> followingTags = new ArrayList<Tag>();

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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
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

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	/**
	 * @return the followingTags
	 */
	public List<Tag> getFollowingTags() {
		return followingTags;
	}

	/**
	 * @param followingTags the followingTags to set
	 */
	public void setFollowingTags(List<Tag> followingTags) {
		this.followingTags = followingTags;
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
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(Long id, @NotBlank String name, Date dateOfBirth) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public User(Long id, Date dateOfBirth) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", dateOfBirth=" + dateOfBirth + ", followingTags=" + followingTags + "]";
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	

}
