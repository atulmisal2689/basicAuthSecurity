package com.jbk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jbk.daoImpl.UserDaoImpl;
import com.jbk.model.User;

@SpringBootApplication
@EntityScan("com.jbk.model")
public class MySpringSecurityApplication implements CommandLineRunner
{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	public static void main(String[] args) 
	{
		SpringApplication.run(MySpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		User user1=new User();
		
		user1.setUsername("mukta");
		user1.setEmail("mukta@gmail.com");
		user1.setRole("Normal");
		user1.setPassword(this.bCryptPasswordEncoder.encode("mukta"));
		this.userDaoImpl.addUser(user1);
		
		
        User user2=new User();
		
		user2.setUsername("roshni");
		user2.setEmail("roshni@gmail.com");
		user2.setRole("Admin");
		user2.setPassword(this.bCryptPasswordEncoder.encode("roshni"));
		this.userDaoImpl.addUser(user2);
		
/*
        User user3=new User();
		
		user3.setUsername("atul");
		user3.setEmail("atul@gmail.com");
		user3.setRole("Admin");
		user3.setPassword(this.bCryptPasswordEncoder.encode("atul"));
		this.userDaoImpl.addUser(user3);
*/		
	}

}
