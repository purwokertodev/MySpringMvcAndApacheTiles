package com.vq.webmon.daoimpl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vq.webmon.dao.UserModelDao;
import com.vq.webmon.domain.UserModel;

@Repository
public class UserModelDaoImpl extends AbstractDaoImpl<UserModel> implements UserModelDao{

	public UserModelDaoImpl(){
		super(UserModel.class);
	}

	@Override
	public UserModel loadByUsername(String username) {
		UserModel um = (UserModel) factory.getCurrentSession().createCriteria(UserModel.class).
				add(Restrictions.eq("username", username)).uniqueResult();
		return um;
	}
	
	
}
