package com.mindtree.newzz.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserLoginDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7042201983318586466L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "User cannot be set to NULL")
	@OneToOne
	private User user;

	@NotEmpty(message = "Email field cannot be blank/NULL")
	@Email(message = "A valid email must be provided")
	private String email;

	@NotEmpty(message = "Password cannot be blank/NULL")
	private String password;

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public UserLoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginDetails(Long id, User user, String email, String password) {
		this.id = id;
		this.user = user;
		this.email = email;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLoginDetails other = (UserLoginDetails) obj;
		return Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "LoginDetails [id=" + id + ", user=" + user + ", email=" + email + ", password=" + password + "]";
	}

}
