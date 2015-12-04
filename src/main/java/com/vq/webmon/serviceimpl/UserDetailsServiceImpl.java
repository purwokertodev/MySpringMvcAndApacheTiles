package com.vq.webmon.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vq.webmon.dao.UserModelDao;
import com.vq.webmon.domain.UserModel;
import com.vq.webmon.domain.UserRole;
import com.vq.webmon.domain.UserStatus;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserModelDao dao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		UserModel um = dao.loadByUsername(username);
		if(um != null){
			String password = um.getPassword();
			
			boolean enabled = um.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired = um.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired = um.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked = um.getStatus().equals(UserStatus.ACTIVE);
			
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for(UserRole ur:um.getRoles()){
				authorities.add(new GrantedAuthorityImpl(ur.getRoleName()));
			}
			
			User securityUsers = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUsers;
		}else{
			throw new UsernameNotFoundException("Username not found");
		}
	}

}
