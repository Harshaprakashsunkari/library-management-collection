package com.capgemini.librarymanagement.controller;

import java.security.Provider.Service;
import java.util.Scanner;

import com.capgemini.librarymanagement.dto.Admin;
import com.capgemini.librarymanagement.dto.Book;
import com.capgemini.librarymanagement.dto.Student;
import com.capgemini.librarymanagement.exception.AdminException;
import com.capgemini.librarymanagement.exception.BookException;
import com.capgemini.librarymanagement.exception.StudentException;
import com.capgemini.librarymanagement.factory.LibraryManagementFactory;
import com.capgemini.librarymanagement.service.LibraryService;

public class LibraryManagementController {
	public static void main(String[] args) {
		doReg();
	}
	public static void doReg() {
		Scanner scan = new Scanner(System.in);
		
			//	LibraryService service = LibraryManagementFactory.getLibraryService();
			System.out.println("Press 1 to Admin");
			System.out.println("Press 2 to Student");
			int i = scan.nextInt();
			switch(i) {
			case 1:
				do {
				LibraryService service = LibraryManagementFactory.getLibraryService();
				System.out.println("Press 1 to Admin Register");
				System.out.println("Enter 2 to Admin Login");
				System.out.println("Press 3 to Exit");

				int a = scan.nextInt();
				switch(a) {
				case 1:
					System.out.println("Enter your Name");
					String adName = scan.next();
					System.out.println("Enter your Email");
					String adEmail = scan.next();
					System.out.println("Enter your Password");
					String adPswd = scan.next();

					Admin admin = new Admin();
					admin.setName(adName);
					admin.setAdEmail(adEmail);
					admin.setAdPassword(adPswd);

					boolean adReg = service.register(admin);
					if(adReg) {
						System.out.println("Registered Successfully");
					}else {
						System.out.println("Registration Failed");
					}
					break;

				case 2:
					System.out.println("Enter your Email");
					String mail = scan.next();
					System.out.println("Enter your Password");
					String pwd = scan.next();
					try {
						Admin ad = service.adminLogin(mail, pwd);
						if(ad != null) {
							System.out.println("Logged in successfully");
						}
						do {
						System.out.println("Press 1 to Add a Book");
						System.out.println("Press 2 to Remove a Book");
						System.out.println("Press 3 to Issue Book");
						System.out.println("Press 4 to Exit");

						int b = scan.nextInt();
						switch(b) {
						case 1:
							Book book = new Book();
							System.out.println("Enter Book Id");
							book.setBookId(Integer.parseInt(scan.next()));
							System.out.println("Enter Name of the Book");
							book.setBookName(scan.next());
							System.out.println("Enter Author of the book");
							book.setBookAuthor(scan.next());
							System.out.println("Enter Publisher Name");
							book.setBookPublisher(scan.next());

							try {
								boolean add = service.addBook(book);
								if(add) {
									System.out.println("Book is added successfully");
								}
							}
							catch(Exception e) {
								//throw new BookException("Book is not added");
								System.out.println("Book is not added");
							}
							break;


						case 2:
							System.out.println("Enter Book Id");
							int bookId = scan.nextInt();
							try {
								boolean remove = service.removeBook(bookId);
								if(remove) {
									System.out.println("Book is removed successfully");
								}
							}catch(Exception e) {
								//throw new BookException("Invalid Book Id");
								System.out.println("Invalid Book Id");
							}
							break;

						case 3:
							System.out.println("Enter Book Id");
							int issued = scan.nextInt();
							try {
								boolean issuedBook = service.issueBook(issued);
								if(issuedBook) {
									System.out.println("Book Issued");
								}
							}catch(Exception e) {
								//throw new BookException("Book is not available");
								System.out.println("Book is not available");
							}
							break;

						case 4:
							doReg();
						default:
							System.out.println("Invalid entry");
							break;
						}
						}while(true);
					}catch(Exception e) {
						System.out.println("Invalid data");
						//throw new AdminException("Invalid Email or Password");
					}break;
					
				case 3:
					doReg();
					break;
				default:
					System.out.println("Invalid Entry");
				}
			}while(true);
			
			case 2:

			do {
				LibraryService service1 = LibraryManagementFactory.getLibraryService();
				System.out.println("Press 1 to Student Register");
				System.out.println("Press 2 to Student Login");
				System.out.println("Press 3 to Exit");
				int c = scan.nextInt();
				boolean isStudent = false;
				switch(c) {

				case 1:
					System.out.println("Enter your Id");
					int regId = scan.nextInt();
					System.out.println("Enter your Name");
					String regName = scan.next();
					System.out.println("Enter your Email");
					String regEmail = scan.next();
					System.out.println("Enter your Password");  
					String regPassword = scan.next();
					System.out.println("Enter your Mobile Number");
					long regMobile = scan.nextLong();
					System.out.println("Enter your branch");
					String regBranch = scan.next();

					Student student = new Student();
					student.setStudentId(regId);
					student.setName(regName);
					student.setEmail(regEmail);
					student.setStPassword(regPassword);
					student.setMobile(regMobile);
					student.setBranch(regBranch);

					boolean reg = service1.register(student);
					if(reg) {
						System.out.println("Registered successfully");
					}else {
						System.out.println("Registration failed");
					}
					break;

				case 2:
					System.out.println("Enter your Email");
					String email = scan.next();
					System.out.println("Enter your Password");
					String password = scan.next();
					try {
						Student stu = service1.studentLogin(email, password);
						if(stu != null) {
							System.out.println("Logged in successfully");
						}
					}catch(Exception e) {
						//throw new StudentException("Invalid Email or password");
						System.out.println("Invalid Email or password");
						doReg();
					}
					do {

						System.out.println("Press 1 to Request for a Book");
						System.out.println("Press 2 to Search for a Book");
						System.out.println("Press 3 to Borrow a Book");
						System.out.println("Press 4 to Return for a Book");
						System.out.println("Press 5 to Exit");
						int d = scan.nextInt();
						switch(d) {

						case 1:
							System.out.println("Enter Book Id");
							int reqBook = scan.nextInt();
							System.out.println("Enter Author Name");
							String reqBookAuthor = scan.next();
							try {
								boolean book = service1.placeReq(reqBook, reqBookAuthor);
								if(book) {
									System.out.println("Requested successfully");
								}else {
									System.out.println("Book not found");
								}
							}catch(Exception e) {
								System.out.println("Invalid data");
							}
							break;

						case 2:
							//if(isStudent) {
								System.out.println("Enter Book Id");
								int searchBookId = scan.nextInt();
								try {
									Book searchBook = service1.searchBook(searchBookId);
									if(searchBook != null) {
										System.out.println("Book Id : "+searchBook.getBookId());
										System.out.println("Book Name : "+searchBook.getBookName());
										System.out.println("Book Author : "+searchBook.getBookAuthor());
										System.out.println("Book Publisher : "+searchBook.getBookPublisher());
									}else {
										System.out.println("Book Not Found");
									}
								}catch(StudentException e){
									System.out.println(e.getMessage());
								}
							
							break;
						case 3:
							System.out.println("Enter your mail id");
							String mailId = scan.next();
							try {
								Student student1 = service1.borrowBook(mailId);
								if(student1 != null) {
									System.out.println("Mail Id : "+email);
									System.out.println(student1.getStudentId());
									System.out.println(student1.getName());
								}else {
									System.out.println("Invalid Data");
								}
							}catch(StudentException e) {	
								System.out.println(e.getMessage());
							}
							break;
						
						case 4:
							System.out.println("Enter Book Id");
							int returned = scan.nextInt();
							try {
								boolean returnBook = service1.returnBook(returned);
								if(returnBook) {
									System.out.println("Book Returned");
								}
							}catch(Exception e) {
								//throw new BookException("Book is not returned");
								System.out.println("Book is not returned");
							}
							break;
								
						case 5:
							doReg();
						default:
							break;
						}}while(true);					
				case 3:
					doReg();
				default:
					System.out.println("Invalid Entry");
					break;
				}
			}while(true);

		}
		while(true);
	}
}
