package com.capgemini.librarymanagementjdbc.factory;

import com.capgemini.librarymanagementjdbc.dao.StudentDAO;
import com.capgemini.librarymanagementjdbc.dao.StudentDAOImplementation;
import com.capgemini.librarymanagementjdbc.service.StudentService;
import com.capgemini.librarymanagementjdbc.service.StudentServiceImplementation;

public class StudentFactory {

	public static StudentDAO getStudentDAO() {
		return new StudentDAOImplementation();
	}
	
	public static StudentService getStudentService() {
		return new StudentServiceImplementation();
	}
	
}
