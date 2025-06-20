package com.finalticapro.application.dto.user;

import java.time.LocalDateTime;

public class UserResponseDTO {

	  	private Long userId;
	    private String firstName;
	    private String lastName;
	    private String username;
	    private String email;
	    private String role;
	    private LocalDateTime createdAt;
	    
	    public UserResponseDTO() {}
	    
	    public UserResponseDTO(Long userId, String firstName, String lastName, String username, String email, String role, LocalDateTime createdAt) {
	    	this.userId=userId;
	    	this.firstName=firstName;
	    	this.lastName=lastName;
	    	this.username=username;
	    	this.email=email;
	    	this.role=role;
	    	this.createdAt=createdAt;
	    }

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
}
