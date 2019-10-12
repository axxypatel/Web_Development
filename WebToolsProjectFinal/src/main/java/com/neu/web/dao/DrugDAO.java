package com.neu.web.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.web.pojo.Drug;

public class DrugDAO extends DAO {

	public void add(Drug drug) {
		begin();
		getSession().save(drug);
		commit();
		close();
	}

	public void edit(Drug drug) {
		begin();
		getSession().update(drug);
		getSession().flush();
		commit();
		close();
	}

	public void delete(Drug drug) {
		
		begin();
		getSession().delete(drug);
		commit();
		close();

	}

	public Drug getDrug(String drugcomid) throws Exception {
		System.out.println("Inside Drug ");
		System.out.println("DrugDAO : " + drugcomid);
		
		Drug drug = null;
		try 
		{
			begin();
			Query q = getSession().createQuery("from Drug where drugcomid = :drugcomid");
			q.setString("drugcomid", drugcomid);
			System.out.println(""+q);
			drug = (Drug) q.setMaxResults(1).uniqueResult();
			if (drug == null)
				System.out.println("DrugDao : Drug is not present in database");
			else
				System.out.println("DrugDao : Drug is available in database");
			commit();
			return drug;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + drugcomid, e);
		}				
	}
	
	
	public List<Drug> getAllDrug(String name) throws HibernateException{
		try 
		{
			begin();
			Query q = getSession().createQuery("from Drug where drugName=:name");
			q.setString("name", name);
			List<Drug> list = q.list();
			commit();
			return list;
		}
		catch (HibernateException e) {
	        rollback();
	        throw new HibernateException("Could not list the drug", e);
	    }
	}

}