package com.expense.calc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.expense.calc.repository.UserRepository;

@Component
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new
				ArrayList<GrantedAuthority>();

		com.expense.calc.model.User userFromDb = userRepository.loadUserByUsername(username);
		User user=null;
		if (userFromDb!=null) {
			user = new User(username, userFromDb.getPassword(), true, true, false, false,
					authorities);
		}
		return user;
		
	}

}
