package com.capgemini.librarymanagementjdbc.service;

import com.capgemini.librarymanagementjdbc.dto.Book;

public interface StudentService {

	boolean placeReq(int bookId,String bookAuthor);
	Book searchBook(int bookId);
	Book borrowBook(String email);
	boolean returnBook(int bookId);

}
