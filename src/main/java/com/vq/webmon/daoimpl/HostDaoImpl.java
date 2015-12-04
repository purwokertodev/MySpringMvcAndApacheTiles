package com.vq.webmon.daoimpl;

import org.springframework.stereotype.Repository;

import com.vq.webmon.dao.HostDao;
import com.vq.webmon.domain.HostModel;

@Repository
public class HostDaoImpl extends AbstractDaoImpl<HostModel> implements HostDao{
	
	public HostDaoImpl(){
		super(HostModel.class);
	}

}
