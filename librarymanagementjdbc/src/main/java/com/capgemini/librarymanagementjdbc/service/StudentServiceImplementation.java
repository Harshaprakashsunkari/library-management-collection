package com.capgemini.librarymanagementjdbc.service;

import com.capgemini.librarymanagementjdbc.dao.StudentDAO;
import com.capgemini.librarymanagementjdbc.dto.Book;
import com.capgemini.librarymanagementjdbc.factory.StudentFactory;

public class StudentServiceImplementation implements StudentService {

	private StudentDAO dao = StudentFactory.getStudentDAO();
	
	@Override
	public boolean placeReq(int bookId, String bookAuthor) {
		return dao.placeReq(bookId, bookAuthor);
	}

	@Override
	public Book searchBook(int bookId) {
		return dao.searchBook(bookId);
	}

	@Override
	public Book borrowBook(String email) {
		return dao.borrowBook(email);
	}

	@Override
	public boolean returnBook(int bookId) {
		return dao.returnBook(bookId);
	}
}
