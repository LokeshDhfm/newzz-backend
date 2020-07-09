package com.mindtree.newzz.utils.dto;

import java.sql.Date;

public class UserSignupDTO {

	private String email;

	private String password;

	private String name;

	private Long phone;

	private Date dateOfBirth;

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

	public UserSignupDTO() {
		super();
	}

	public UserSignupDTO(String email, String password, String name, Long phone, Date dateOfBirth) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
	}

}
