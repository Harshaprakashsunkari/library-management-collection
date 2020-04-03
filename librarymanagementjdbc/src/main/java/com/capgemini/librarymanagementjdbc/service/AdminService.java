package com.capgemini.librarymanagementjdbc.service;

import com.capgemini.librarymanagementjdbc.dto.Book;

public interface AdminService {

	int addBook(Book book);
	int removeBook(int bookId);
	boolean issueBook(int bookId);
	
	
}
