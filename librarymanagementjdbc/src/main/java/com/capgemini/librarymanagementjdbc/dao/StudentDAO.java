package com.capgemini.librarymanagementjdbc.dao;

import com.capgemini.librarymanagementjdbc.dto.Book;

public interface StudentDAO {
	
	boolean placeReq(int bookId,String bookAuthor);
	Book searchBook(int bookId);
	Book borrowBook(String email);
	boolean returnBook(int bookId);
}
