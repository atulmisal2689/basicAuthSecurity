package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.UserDaoImpl;
import com.jbk.model.User;

@Service
public class UserService 
{
 
	@Autowired
	UserDaoImpl userDaoImpl;
	
   public List<User>getAllUsers()
   {
	   return this.userDaoImpl.getAllUsers();
   }
   
   public User getUser(String username)
   {
	   return this.userDaoImpl.getUser(username);
	  
   }
   
   public User addUser(User user)
   {
	   return this.userDaoImpl.addUser(user);
   }

}
