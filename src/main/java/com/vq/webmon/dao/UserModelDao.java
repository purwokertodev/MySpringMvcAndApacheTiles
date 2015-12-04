package com.vq.webmon.dao;

import com.vq.webmon.domain.UserModel;

public interface UserModelDao extends AbstractDao<UserModel>{
	
	UserModel loadByUsername(String username);

}
