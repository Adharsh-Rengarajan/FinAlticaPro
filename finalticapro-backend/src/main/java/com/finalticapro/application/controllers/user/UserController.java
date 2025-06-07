package com.finalticapro.application.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalticapro.application.dto.user.UserRequestDTO;
import com.finalticapro.application.dto.user.UserResponseDTO;
import com.finalticapro.application.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@PostMapping("/signup")
	public UserResponseDTO createUser(@RequestBody UserRequestDTO user)
	{
		return userService.createUser(user);
	}
	
	
	@PostMapping("/login")
	public UserResponseDTO login(
	    @RequestParam String username, 
	    @RequestParam String password) {
	    return userService.login(username, password);
	}
	
	@GetMapping
	public String greeting()
	{
		return "Working";
	}
}
