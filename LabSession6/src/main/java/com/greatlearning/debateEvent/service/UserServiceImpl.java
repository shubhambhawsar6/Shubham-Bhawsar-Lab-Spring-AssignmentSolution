package com.greatlearning.debateEvent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.debateEvent.entity.User;
import com.greatlearning.debateEvent.repositories.UserRepository;
import com.greatlearning.debateEvent.security.StudentUserDetails;

public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found !!!");
		}
		UserDetails studentUserDetails = new StudentUserDetails(user);
		return studentUserDetails;
	}

}
