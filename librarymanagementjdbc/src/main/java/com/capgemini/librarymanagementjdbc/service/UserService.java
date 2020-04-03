package com.capgemini.librarymanagementjdbc.service;

import com.capgemini.librarymanagementjdbc.dto.User;

public interface UserService {

	int register(User user);
	String auth(String email, String password);
}
