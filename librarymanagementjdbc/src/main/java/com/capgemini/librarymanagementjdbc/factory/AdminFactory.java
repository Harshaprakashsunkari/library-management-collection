package com.capgemini.librarymanagementjdbc.factory;

import com.capgemini.librarymanagementjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementjdbc.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementjdbc.dao.StudentDAO;
import com.capgemini.librarymanagementjdbc.service.AdminService;
import com.capgemini.librarymanagementjdbc.service.AdminServiceImplementation;

public class AdminFactory {

	public static AdminDAO getAdminDAO() {
		return new AdminDAOImplementation(); 
	}
	
	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}
	
}
