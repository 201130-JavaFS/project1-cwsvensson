package com.rev_cws.models;

public class LoginDTO {
	
	public String username;  // Allows for Getters and Setters to be skipped
	public String password;  // Also public versus private.

	public LoginDTO() {
		super();
	}

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}