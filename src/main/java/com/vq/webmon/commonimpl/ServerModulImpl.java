package com.vq.webmon.commonimpl;

import java.net.InetAddress;
import java.net.Socket;

import org.springframework.stereotype.Service;

import com.vq.webmon.common.ServerModul;
import com.vq.webmon.domain.HostModel;

@Service
public class ServerModulImpl implements ServerModul{

	private Socket sc;

	@Override
	public void connect(HostModel h) {
		try{
			sc = new Socket(h.getHostName(), h.getPort());
			InetAddress ia = sc.getInetAddress();
			System.out.println("---------- Status Connected to "+ia.getHostName()+" ----------");
		}catch(Exception ex){
			
		}
	}

	@Override
	public void disconnect() {
		
	}

}
