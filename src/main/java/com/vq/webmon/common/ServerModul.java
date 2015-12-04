package com.vq.webmon.common;


import com.vq.webmon.domain.HostModel;


public interface ServerModul {
	
	public void connect(HostModel h);
	public void disconnect();

}
