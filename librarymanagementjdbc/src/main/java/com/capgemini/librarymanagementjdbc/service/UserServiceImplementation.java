package com.capgemini.librarymanagementjdbc.service;

import com.capgemini.librarymanagementjdbc.dao.UserDAO;
import com.capgemini.librarymanagementjdbc.dto.User;
import com.capgemini.librarymanagementjdbc.factory.UserFactory;

public class UserServiceImplementation implements UserService{

	private UserDAO dao = UserFactory.getUser();
	
	@Override
	public int register(User user) {
		return dao.register(user);
	
	}

	@Override
	public String auth(String email, String password) {
		return dao.auth(email, password);
	}
}
