package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dto.Admin;
import com.capgemini.librarymanagement.dto.Book;
import com.capgemini.librarymanagement.dto.Student;
import com.capgemini.librarymanagement.factory.LibraryManagementFactory;

public class LibraryServiceImplement implements LibraryService{

	private StudentDAO dao1 = LibraryManagementFactory.getStudentDAO();
	private AdminDAO dao2 = LibraryManagementFactory.getAdminDAO();
	
	public boolean register(Student student) {
		return dao1.register(student);
	}
	public Student studentLogin(String email, String password) {
		return dao1.studentLogin(email, password);
	}
	public boolean placeReq(int bookId, String bookAuthor) {
		return dao1.placeReq(bookId, bookAuthor);
	}
	public Book searchBook(int bookId) {

		return dao1.searchBook(bookId);
	}
	public Student borrowBook(String email) {
		return dao1.borrowBook(email);
	}
	public boolean returnBook(int bookId) {
		return dao1.returnBook(bookId);
	}
	public boolean register(Admin admin) {
		return dao2.register(admin);				
	}
	public Admin adminLogin(String adEmail, String password) {
		return dao2.adminLogin(adEmail, password); 
	}
	public boolean addBook(Book book) {
		return dao2.addBook(book);
	}
	public boolean removeBook(int bookId) {
		return dao2.removeBook(bookId);
	}
	public boolean issueBook(int bookId) {
		return dao2.issueBook(bookId);
	}	
}
