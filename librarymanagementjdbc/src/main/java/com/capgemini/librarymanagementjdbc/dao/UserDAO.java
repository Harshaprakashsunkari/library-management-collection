package com.capgemini.librarymanagementjdbc.dao;

import com.capgemini.librarymanagementjdbc.dto.User;

public interface UserDAO {

	int register(User user);
	String auth(String email, String password);
	
}
