package com.example.abccollege.studentmanagementservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.abccollege.studentmanagementservice.entity.User;
import com.example.abccollege.studentmanagementservice.repo.UserRepository;
import com.example.abccollege.studentmanagementservice.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.getUserByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Could not find user with username: " + username);
		return new MyUserDetails(user);
	}
}
