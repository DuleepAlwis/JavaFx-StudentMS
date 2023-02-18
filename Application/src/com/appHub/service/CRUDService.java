package com.appHub.service;

public interface CRUDService <I,T> {

	public I save(T user);
	public I update(T user);
	public T getByName(String name);
	public T getById(Long id);
	public I delete(T user);
}
