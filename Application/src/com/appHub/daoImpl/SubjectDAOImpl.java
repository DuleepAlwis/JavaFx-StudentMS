package com.appHub.daoImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.appHub.dao.CrudDAO;
import com.appHub.entity.SubjectEntity;
import com.appHub.entity.UserEntity;
import com.appHub.util.HibernateUtil;
import com.appHub.util.ResponseMessage;

public class SubjectDAOImpl implements CrudDAO<Boolean,SubjectEntity>{

	private final static Logger logger = Logger.getLogger(SubjectDAOImpl.class.getName());
	
	@Override
	public Boolean save(SubjectEntity subject) {
		SessionFactory sf = null;
		Session session =null;
		Transaction tx = null;
		try {
			 sf = HibernateUtil.getSessionFactory();
			 session = sf.getCurrentSession();
			 tx = session.beginTransaction();
			session.save(subject);
			tx.commit();
			logger.log(Level.INFO, "Subject saved "+subject.getName());
			return true;
		} catch(Exception ex) {
			
			logger.log(Level.SEVERE, ex.getMessage());

			tx.rollback();
		}
		
		return false; 
	}

	@Override
	public Boolean update(SubjectEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectEntity searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectEntity searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(SubjectEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SubjectEntity searchByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SubjectEntity> getAll(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<SubjectEntity> users = session.createQuery("SELECT subject FROM SubjectEntity subject", SubjectEntity.class).getResultList();      
		
		tx.commit();
		logger.log(Level.INFO, ResponseMessage.ALL_THE_SUBJECTS);
		return users;
	}

}
