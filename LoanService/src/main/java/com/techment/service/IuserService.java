package com.techment.service;

import java.util.Optional;

import com.techment.entity.User;

public interface IuserService {

	Optional<User> findBytoken(String token);
	User login(String username,String password);
	User register(String username,String password);

}
