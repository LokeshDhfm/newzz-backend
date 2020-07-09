package com.mindtree.newzz.utils.dto;

public class UserLoginDTO {
	
	private String email;
	
	private String password;

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

	public UserLoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginDTO [email=" + email + ", password=" + password + "]";
	}
	
	

}
