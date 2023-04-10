package net.project.moving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.project.moving.dao.UserDao;
import net.project.moving.domain.User;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserDao dao;
	
	public void signUp(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPw());
		user.setPw(encodedPassword);
		
		dao.signUp(user);
	}

}
