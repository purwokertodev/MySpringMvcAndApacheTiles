package com.vq.webmon.dao;

import java.util.List;

public interface AbstractDao <T>{
	
	void save(T t);
	void update(T t);
	void delete(T t);
	T findOne(Object id);
	List<T> findAll();

}
