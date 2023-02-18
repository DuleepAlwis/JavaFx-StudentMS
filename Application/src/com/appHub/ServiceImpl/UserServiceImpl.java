package com.appHub.ServiceImpl;

import java.util.List;

import com.appHub.daoImpl.UserDAOImpl;
import com.appHub.entity.UserEntity;
import com.appHub.service.CRUDService;
import com.appHub.util.PasswordUtil;

import javafx.scene.control.PasswordField;

public class UserServiceImpl implements CRUDService<Boolean, UserEntity> {

	@Override
	public Boolean save(UserEntity user) {
		UserDAOImpl userDAO = new UserDAOImpl();
		user.setPassword(PasswordUtil.encodePassword(user.getPassword()));
		return userDAO.save(user);
	}

	@Override
	public Boolean update(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public UserEntity login(String email,String password) {
		UserDAOImpl userDAO = new UserDAOImpl();
		password = PasswordUtil.encodePassword(password);
		return userDAO.login(email,password);
	}

	public List<UserEntity> getAllUsers(){
		UserDAOImpl userDAO = new UserDAOImpl();
		
		return userDAO.getAllUsers();
	}
}
