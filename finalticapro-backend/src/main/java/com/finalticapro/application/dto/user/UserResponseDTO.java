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
}
