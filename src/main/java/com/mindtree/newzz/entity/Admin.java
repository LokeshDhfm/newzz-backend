package com.mindtree.newzz.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2260064613443646298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String email;

	private String name;

	private String password;

	private Long phone;

	private Date dateOfBirth;

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

	public Admin(Long id, String email, String name, String password, Long phone, Date dateOfBirth) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
