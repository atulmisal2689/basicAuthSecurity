package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.User;
import com.jbk.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	UserService userService;
	
	
	@GetMapping("/getAllUsers")
	public List<User>getAllUsers()
	{
        return this.userService.getAllUsers();
	}
	
	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable String username)
	{
        return this.userService.getUser(username);
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user)
	{
	    User addedUser = this.userService.addUser(user);
	    
	    if(addedUser!=null)  
		{
			return user;  
		}
		else
		{
			return null;
		}
	}
}
