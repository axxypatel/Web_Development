package com.neu.web.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;

import com.neu.web.dao.DAO;
import com.neu.web.pojo.User;


public class UserDAO extends DAO {

	public void add(User user) {
		begin();
		getSession().save(user);
		commit();
		close();
	}

	public void edit(User user) {
		begin();
		getSession().update(user);
		this.getSession().flush();
		commit();
		close();
	}

	public void delete(User user) {
		
		begin();
		getSession().delete(user);
		commit();
		close();

	}

	public User getUser(String username) throws Exception {
		System.out.println("Inside get User ");
		System.out.println("UserDao : " + username);
		
		User user = null;
		try 
		{
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			System.out.println(""+q);
			user = (User) q.setMaxResults(1).uniqueResult();
			if (user == null)
				System.out.println("UserDao : user is not present in database");
			else
				System.out.println("UserDao : user is available in database");
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}				
	}

	public User checkUser(String username, String password) throws Exception {		
		System.out.println("Checking Login");
		System.out.println("User in database : " + username);
		System.out.println("User in database : " + password);
		
		User user = null;
		try 
		{
			begin();
			Query q = getSession().createQuery("from User where username = :username and password=:password");
			q.setString("username", username);
			q.setString("password", password);
			System.out.println(""+q);
			user = (User) q.setMaxResults(1).uniqueResult();
			if (user == null)
				System.out.println("UserDao : user login failed");
			else
				System.out.println("UserDao : user login successful");
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + username, e);
		}	
		
	}
	public List getAllUser() {
		
		return getSession().createQuery("from User").list();
	}

}
