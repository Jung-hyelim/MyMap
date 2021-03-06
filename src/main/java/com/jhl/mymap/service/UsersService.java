package com.jhl.mymap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jhl.mymap.entity.Users;
import com.jhl.mymap.repository.UsersRepository;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Users createUser(String username, String password) {
		Users user = new Users(null, username, passwordEncoder.encode(password));
		return usersRepository.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> find = usersRepository.findByUsername(username);
		Users user = find.orElseThrow(() -> new UsernameNotFoundException(username));
		return user;
	}

	public void deleteUser(Long id) {
		usersRepository.deleteById(id);
	}
}
