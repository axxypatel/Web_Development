package com.neu.web.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neu.web.pojo.User;

//package com.me.book.dao;

import java.util.List;

public class DAO {

	private static final Logger log = Logger.getAnonymousLogger();

	private static final ThreadLocal sessionThread = new ThreadLocal();
	public static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public static Session getSession() {
		Session session = (Session) sessionThread.get();

		if (session == null) {
			session = sessionFactory.openSession();
			sessionThread.set(session);
		}
		return session;
	}

	protected void begin() {
		getSession().beginTransaction();
	}

	protected void commit() {
		getSession().getTransaction().commit();
	}

	protected void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot rollback", e);
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot close", e);
		}
		sessionThread.set(null);
	}

	public static void close() {
		getSession().close();
		sessionThread.set(null);
	}

}
