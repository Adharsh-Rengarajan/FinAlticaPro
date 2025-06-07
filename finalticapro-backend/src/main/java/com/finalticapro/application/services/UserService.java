package com.finalticapro.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalticapro.application.dto.user.UserRequestDTO;
import com.finalticapro.application.dto.user.UserResponseDTO;
import com.finalticapro.application.entities.user.User;
import com.finalticapro.application.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public UserResponseDTO createUser(UserRequestDTO request)
	{

	    User user = new User();
	    user.setFirstName(request.getFirstName());
	    user.setLastName(request.getLastName());
	    user.setUsername(request.getUsername());
	    user.setEmail(request.getEmail());
	    user.setPassword(request.getPassword()); 
	    user.setRole("USER");
	    
	    if(userRepository.existsByEmail(user.getEmail())) {
	    	throw new RuntimeException("Email Already Exist");
	    }
	    
	    else if(userRepository.existsByUsername(user.getUsername()))
	    {
	    	throw new RuntimeException("Username Already Exist");
	    }
	    
	    User savedUser = userRepository.save(user); 
	    return changeToUserDTO(savedUser);
	        
	}
	
	public UserResponseDTO changeToUserDTO(User user) {
		UserResponseDTO userResponseDTO=new UserResponseDTO(user.getUserId(),user.getFirstName(),user.getLastName(),user.getUsername(),user.getEmail(),user.getRole(),user.getUpdatedAt());
		return userResponseDTO;
	}
	
	
}
