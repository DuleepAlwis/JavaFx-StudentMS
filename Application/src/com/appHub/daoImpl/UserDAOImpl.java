package com.appHub.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appHub.dao.CrudDAO;
import com.appHub.entity.UserEntity;
import com.appHub.util.HibernateUtil;

public class UserDAOImpl implements CrudDAO<Boolean , UserEntity> {

	private final static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

	@Override
	public Boolean save(UserEntity user) {
		SessionFactory sf = null;
		Session session =null;
		Transaction tx = null;
		try {
			 sf = HibernateUtil.getSessionFactory();
			 session = sf.getCurrentSession();
			 tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			logger.log(Level.INFO, "User saved "+user.getEmail());
			return true;
		} catch(Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());

			tx.rollback();
		}
		
		return false; 
	}

	@Override
	public Boolean update(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserEntity searchByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEntity login(String email,String password) {
		UserEntity ue = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try {
			 sf = HibernateUtil.getSessionFactory();
			 session = sf.getCurrentSession();
			 tx = session.beginTransaction();

			@SuppressWarnings("deprecation")
			Query query=session.createQuery("from UserEntity where email=:email and password=:password");
			query.setParameter("email", email);
			query.setParameter("password",password);
			ue=(UserEntity)query.uniqueResult();
			tx.commit();
			logger.log(Level.INFO,"User "+email+" loggedin");
			//sf is not closed because it is needed in other transactions
		} catch(Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());
			tx.rollback();
			
		}
		
		return ue;
	}
	
	public List<UserEntity> getAllUsers(){
		
		 
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<UserEntity> users = session.createQuery("SELECT user FROM UserEntity user", UserEntity.class).getResultList();      
		
		tx.commit();
		logger.log(Level.INFO, "All the users are fetched");
		return users;
		
	}

	
}
