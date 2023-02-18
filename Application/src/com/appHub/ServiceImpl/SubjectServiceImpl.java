package com.appHub.ServiceImpl;

import java.util.List;

import com.appHub.daoImpl.SubjectDAOImpl;
import com.appHub.entity.SubjectEntity;
import com.appHub.service.CRUDService;

public class SubjectServiceImpl implements CRUDService<Boolean, SubjectEntity>{

	private final static SubjectDAOImpl sub = new SubjectDAOImpl();
	
	@Override
	public Boolean save(SubjectEntity subject) {
		return sub.save(subject);
	}

	@Override
	public Boolean update(SubjectEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectEntity getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(SubjectEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SubjectEntity> getAll(){
		return sub.getAll();
		
	}

}
