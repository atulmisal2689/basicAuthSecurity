package com.jbk.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.model.User;

@Repository
public class UserDaoImpl 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<User>getAllUsers()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> list = criteria.list();
		return list;

	}


	public User getUser(String username)
	{
		Session session = sessionFactory.openSession();
		 User userfromDb = session.get(User.class, username);
		 if(userfromDb!=null)
		 {
			 return userfromDb;
		 }
		return null;

	}

	public User addUser(User user)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
	  User userfromDb = session.get(User.class, user.getUsername());
	  
	  if(userfromDb==null)  
		{
			//If id realated object is not present in database
			session.save(user); 
			transaction.commit();
			return user;  
		}
		else
		{
			//If id realated object is present in database
			transaction.rollback();
			return null;
		}

	}
}
