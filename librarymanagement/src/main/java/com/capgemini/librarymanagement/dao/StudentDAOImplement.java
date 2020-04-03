package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.database.DataBase;
import com.capgemini.librarymanagement.dto.Book;
import com.capgemini.librarymanagement.dto.Student;
import com.capgemini.librarymanagement.exception.BookException;
import com.capgemini.librarymanagement.exception.StudentException;

public class StudentDAOImplement implements StudentDAO{

	DataBase db = new DataBase();

	public boolean register(Student student) {
		if(student.getEmail().equals(DataBase.STUDENT.containsKey(student.getEmail())) ||
				student.getEmail().equals(null)){
			throw new StudentException("Email Id already exists");
		}
		DataBase.STUDENT.put(student.getEmail(), student);
		return true;

	}

	public Student studentLogin(String email, String password) {
		Student student = DataBase.STUDENT.get(email);
		if((student.getEmail().equals(email)) && (student.getStPassword().equals(password))){
			return student;
		}
		throw new StudentException("Exception caught @ Login");

	}

	public boolean placeReq(int bookId, String bookAuthor) {
		boolean req = DataBase.BOOK.containsKey(bookId);
		if(req) {
			return true;
		}else{
			return false;
		}
	}

	public Book searchBook(int bookId) {

		boolean isExist = DataBase.BOOK.containsKey(bookId);
		if(isExist) {
			Book bookInfo = DataBase.BOOK.get(bookId);
			return bookInfo;
		}else {
			throw new BookException("Enter Valid Book Id");
		}
	}

	public Student borrowBook(String email) {

		boolean borrowed = DataBase.BOOK.containsKey(email);
		if(borrowed) {
			Student student = DataBase.STUDENT.get(email);
			return student;
		}else {
			throw new StudentException("Student data not available");
		}
	}

	public boolean returnBook(int bookId) {

		boolean returned =	DataBase.BOOK.containsKey(bookId);
		if(returned) {
			Book b =	DataBase.BOOK.get(bookId);
			DataBase.BOOK.put(b.getBookId(), b);
			return true;
		}else {
			throw new BookException("The Book issued is not matching");		
		}
	}
}
