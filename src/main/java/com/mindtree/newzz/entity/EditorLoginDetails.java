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
public class EditorLoginDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553230478968948158L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Editor cannot be set to NULL")
	@OneToOne
	private Editor editor;
	
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

	public EditorLoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditorLoginDetails(Long id, @NotNull(message = "Editor cannot be set to NULL") Editor editor,
			@NotEmpty(message = "Email field cannot be blank/NULL") @Email(message = "A valid email must be provided") String email,
			@NotEmpty(message = "Password cannot be blank/NULL") String password) {
		this.id = id;
		this.editor = editor;
		this.email = email;
		this.password = password;
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
		EditorLoginDetails other = (EditorLoginDetails) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "EditorLoginDetails [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
