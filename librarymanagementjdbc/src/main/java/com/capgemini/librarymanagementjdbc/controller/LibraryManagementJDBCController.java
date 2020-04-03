package com.capgemini.librarymanagementjdbc.controller;

import java.util.Scanner;

import com.capgemini.librarymanagementjdbc.dto.Book;
import com.capgemini.librarymanagementjdbc.dto.User;
import com.capgemini.librarymanagementjdbc.factory.AdminFactory;
import com.capgemini.librarymanagementjdbc.factory.StudentFactory;
import com.capgemini.librarymanagementjdbc.factory.UserFactory;
import com.capgemini.librarymanagementjdbc.service.AdminService;
import com.capgemini.librarymanagementjdbc.service.StudentService;
import com.capgemini.librarymanagementjdbc.service.UserService;

public class LibraryManagementJDBCController {

	public static void main(String[] args) {
		doReg();
	}

	public static void doReg() {

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
			UserService service = UserFactory.getUserService();
			AdminService service1 = AdminFactory.getAdminService();

			int i = scanner.nextInt();

			switch(i) {
			case 1:

				System.out.println("Enter Name");
				String regName = scanner.next();
				System.out.println("Enter Email");
				String regEmail = scanner.next();
				System.out.println("Enter Password");
				String regPassword = scanner.next();
				System.out.println("Enter Mobile");
				long regMobile = scanner.nextLong();
				System.out.println("Enter Role");
				String regRole = scanner.next();
				System.out.println("Enter ID");
				int regID = scanner.nextInt();

				User bean = new User();
				bean.setId(regID);
				bean.setName(regName);
				bean.setMobile(regMobile);
				bean.setEmail(regEmail);
				bean.setPassword(regPassword);
				bean.setRole(regRole);

				try {
					int check = service.register(bean);
					if(check == 0) {
						System.out.println("Email already exists");
					} else {
						System.out.println("Registered Successfully");
					}
				}catch(Exception e) {
					System.out.println("Invalid");
				}
				break;
				
			case 2:
				String student = null;
				String admin = null;
				String role = null;
				System.out.println("Enter Email");
				String email = scanner.next();
				System.out.println("Enter Password");
				String password = scanner.next();

				try {
					String auth = service.auth(email, password);
					if(auth.equalsIgnoreCase("Admin")) {
						admin();

					}else if(auth.equalsIgnoreCase("Student")){
						System.out.println("Student");
					}

					else {
						System.out.println("Invalid email and password");
					}
				}catch(Exception e) {
					System.out.println("Invalid credentials");
				}
				break;
			}
		}while(true);	
	}

	public static void admin() {
		UserService service = UserFactory.getUserService();
		AdminService service1 = AdminFactory.getAdminService();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 1 to Add Book");
		System.out.println("Press 2 to Remove Book");
		System.out.println("Press 3 to Issue book");
		System.out.println("Press 4 to Main");

		int choice1 = scanner.nextInt();
		switch (choice1) {
		case 1:

			System.out.println("Enter ID");
			int bookId = scanner.nextInt();
			System.out.println("Enter Book Name"); 
			String bookName = scanner.next();
			System.out.println("Enter Author"); 
			String bookAuthor = scanner.next();
			System.out.println("Enter Publisher Name");
			String bookPublisher =  scanner.next();

			Book bean2 = new Book();
			bean2.setBookId(bookId); 
			bean2.setBookName(bookName);
			bean2.setBookAuthor(bookAuthor);
			bean2.setBookPublisher(bookPublisher);

			int check = service1.addBook(bean2);
			if(check==0) {
				System.out.println("Book already exists");
			} else {
				System.out.println("Book added");
			}
			break;

		case 2:
			System.out.println("Enter the Book Id:");
			int book_Id = scanner.nextInt();
			if (book_Id == 0) {
				System.out.println("Enter the Valid Book Id");
			} else {
				Book bean3 = new Book();

				bean3.setBookId(book_Id);
				int remove = service1.removeBook(book_Id);
				if (remove == 0) {
					System.out.println("The Book is not removed");
				} else {
					System.out.println("The Book is removed");
				}
			}
			break;

		case 3:
			
			// Issue book
			
		}
	}

	public static void student() {
		Scanner scanner = new Scanner(System.in);
		StudentService service2 = StudentFactory.getStudentService();
		do {
			try {

				System.out.println("Press 1 to Request a book");
				System.out.println("Press 2 to Search a Book Id");
				System.out.println("Press 3 to Borrow a book");
				System.out.println("Press 4 to Return a book");
				System.out.println("Press 5 to Main");

				int choice2 = scanner.nextInt();
				switch (choice2) { 
				case 1:
					System.out.println("Enter Book Id");
					int reqBookId = scanner.nextInt();
					System.out.println("Enter Author Name");
					String reqBookAuthor = scanner.next();
					boolean book = service2.placeReq(reqBookId, reqBookAuthor);
					if(book) {
						System.out.println("Requested Successfully");
					}else {
						System.out.println("Book Not Found");
					}
					break;

				case 2:
					System.out.println("Enter Book id");
					int id = scanner.nextInt();
					Book bean5 = new Book();
					bean5.setBookId(id);
					Book list2 = service2.searchBook(id);
					if(list2!=null) {
						System.out.println(list2.getBookId());
						System.out.println(list2.getBookName());
						System.out.println(list2.getBookAuthor());
						System.out.println(list2.getBookPublisher());
						System.out.println(list2);
					} else {
						System.out.println("Book Not Found");
					}
					break;

				case 3:

					// Borrow book
					
				case 4:
					System.out.println("enter id");
					int returned = scanner.nextInt();
					boolean returnBook = service2.returnBook(returned);
					if(returnBook) {
						System.out.println("Book returned");
					}else {
						System.out.println("Book not Returned");
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Credentials");
			}
			break;

		}while(true);
	} 
}
