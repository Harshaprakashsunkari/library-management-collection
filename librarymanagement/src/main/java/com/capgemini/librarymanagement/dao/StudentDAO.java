package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.Book;
import com.capgemini.librarymanagement.dto.Student;

public interface StudentDAO {
	
	boolean register(Student student);
	Student studentLogin(String email, String password);
	boolean placeReq(int bookId,String bookAuthor);
	Book searchBook(int bookId);
	Student borrowBook(String email);
	boolean returnBook(int bookId);
}
