package com.capgemini.librarymanagementjdbc.service;

import com.capgemini.librarymanagementjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementjdbc.dto.Book;
import com.capgemini.librarymanagementjdbc.factory.AdminFactory;

public class AdminServiceImplementation implements AdminService {

	private AdminDAO dao = AdminFactory.getAdminDAO();
	
	@Override
	public int addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public int removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	@Override
	public boolean issueBook(int bookId) {
		return dao.issueBook(bookId);
	}

}
