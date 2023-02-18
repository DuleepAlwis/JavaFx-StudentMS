package com.appHub.dao;

public interface CrudDAO <I,T>{

	public I save(T user);
	public I update(T user);
	public T searchByName(String name);
	public T searchById(Long id);
	public boolean delete(T user);
	public T searchByEmail(String email);
}
