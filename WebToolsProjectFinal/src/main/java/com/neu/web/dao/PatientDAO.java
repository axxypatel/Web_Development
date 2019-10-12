package com.neu.web.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.web.pojo.Patient;

public class PatientDAO extends DAO {

	public void add(Patient patient) {
		begin();
		getSession().save(patient);
		commit();
		close();
	}

	public void edit(Patient patient) {
		begin();
		getSession().update(patient);
		this.getSession().flush();
		commit();
		close();
	}

	public void delete(Patient patient) {
		
		begin();
		getSession().delete(patient);
		commit();
		close();

	}

	public Patient getPatient(String mobile) throws Exception {
		System.out.println("Inside get Patient ");
		System.out.println("Patient Number : " + mobile);
		
		Patient patient = null;
		try 
		{
			begin();
			Query q = getSession().createQuery("from Patient where patientMobile = :mobile");
			q.setString("mobile", mobile);
			System.out.println(""+q);
			patient = (Patient) q.setMaxResults(1).uniqueResult();
			if (patient == null)
				System.out.println("PatientDAO : patient is not present in database");
			else
				System.out.println("PatientDAO : patient is available in database");
			commit();
			return patient;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + mobile, e);
		}				
	}
//
//	public User checkUser(String username, String password) throws Exception {		
//		System.out.println("Checking Login");
//		System.out.println("User in database : " + username);
//		System.out.println("User in database : " + password);
//		
//		User user = null;
//		try 
//		{
//			begin();
//			Query q = getSession().createQuery("from User where username = :username and password=:password");
//			q.setString("username", username);
//			q.setString("password", password);
//			System.out.println(""+q);
//			user = (User) q.setMaxResults(1).uniqueResult();
//			if (user == null)
//				System.out.println("UserDao : user login failed");
//			else
//				System.out.println("UserDao : user login successful");
//			commit();
//			return user;
//		} catch (HibernateException e) {
//			rollback();
//			throw new Exception("Could not get user " + username, e);
//		}	
//		
//	}
	public List<Patient> getAllPatient(String name) throws HibernateException{
		try 
		{
			begin();
			Query q = getSession().createQuery("from Patient where patientName=:name");
			q.setString("name", name);
			List<Patient> list = q.list();
			commit();
			return list;
		}
		catch (HibernateException e) {
	        rollback();
	        throw new HibernateException("Could not list the Patient", e);
	    }
	}
	
	

}

