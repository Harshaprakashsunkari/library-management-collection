package com.capgemini.librarymanagementjdbc.dao;

import com.capgemini.librarymanagementjdbc.dto.Book;

public interface AdminDAO {

	int addBook(Book book);
	int removeBook(int bookId);
	boolean issueBook(int bookId);
	
}
