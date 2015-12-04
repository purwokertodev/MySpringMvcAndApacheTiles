package com.vq.webmon.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vq.webmon.dao.AbstractDao;

public class AbstractDaoImpl<T> implements AbstractDao<T>{
	
	private Class<T> domain;
	
	public AbstractDaoImpl(Class<T> domain){
		this.domain = domain;
	}
	
	@Autowired
	protected SessionFactory factory;

	@Override
	public void save(T t) {
		factory.getCurrentSession().save(t);
	}

	@Override
	public void update(T t) {
		factory.getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		factory.getCurrentSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOne(Object id) {
		return (T) factory.getCurrentSession().get(domain,(Serializable) id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return factory.getCurrentSession().createCriteria(domain).list();
	}
	
	

}
