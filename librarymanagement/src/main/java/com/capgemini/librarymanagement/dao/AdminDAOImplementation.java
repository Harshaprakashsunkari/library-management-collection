package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.database.DataBase;
import com.capgemini.librarymanagement.dto.Admin;
import com.capgemini.librarymanagement.dto.Book;
import com.capgemini.librarymanagement.exception.AdminException;
import com.capgemini.librarymanagement.exception.BookException;

public class AdminDAOImplementation implements AdminDAO{


	public boolean register(Admin admin) {
		if(admin.getAdEmail().equals(DataBase.ADMIN.containsKey(admin.getAdEmail())) && 
				admin.getAdEmail().equals(null)) {
			return false;
			//throw new AdminException("Email Id already exists");
		}else {
			DataBase.ADMIN.put(admin.getAdEmail(), admin);
			return true;
		}
	}

	public Admin adminLogin(String adEmail, String password) {
		Admin admin = DataBase.ADMIN.get(adEmail);
		
		if(admin.getAdEmail().equals(adEmail) && (admin.getAdPassword().equals(password))) {
			return admin;
		}else {
			throw new AdminException("Exception caught @ Login");
		}
	}

	public boolean addBook(Book book) {
		DataBase.BOOK.put(book.getBookId(), book);
		boolean addBook = DataBase.BOOK.containsKey(book.getBookId());
		if(addBook) {
			return addBook;
		}else {
			throw new BookException("Book is not added");
		}
	}

	public boolean removeBook(int book) {
		boolean remove = DataBase.BOOK.containsKey(book);
		if(remove) {
			DataBase.BOOK.remove(book);
			return true;
		}else {
			throw new BookException("Book is not available");
		}
	}

	public boolean issueBook(int bookId) {
		boolean issue = DataBase.BOOK.containsKey(bookId);
		if(issue) {
			DataBase.BOOK.remove(bookId);
			return true;
		}else {
			throw new BookException("Book is not available");
		}
		
	}

}
