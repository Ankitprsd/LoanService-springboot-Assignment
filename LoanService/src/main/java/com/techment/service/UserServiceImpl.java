package com.techment.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.techment.entity.User;
import com.techment.exception.InvalidUserException;
import com.techment.repository.UserRepository;
import com.techment.util.SiteUtil;

@Service
public class UserServiceImpl implements IuserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SiteUtil siteutil;

	
			@Override
			public User login(String username, String password) throws NoSuchElementException {

				User user =	userRepository.findByUsernameAndPassword(username, password).get();
			
				String token = siteutil.generateToken();
				user.setToken(token);
				userRepository.save(user);
				User user1 = new User(user.getUsername(),user.getPassword(),"mytoken");
				return user1;
			}


			@Override
			public Optional<User> findBytoken(String token) {
				return userRepository.findBytoken(token);
			}


			@Override
			public User register(String username, String password) throws InvalidUserException {
				
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
			
				userRepository.save(user);
				System.out.println("welcome user");
                return user;
			
			}

		
	

}
