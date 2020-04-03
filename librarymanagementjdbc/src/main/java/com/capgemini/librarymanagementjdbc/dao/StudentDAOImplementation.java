package com.capgemini.librarymanagementjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.capgemini.librarymanagementjdbc.dto.Book;

public class StudentDAOImplementation implements StudentDAO{

	public boolean placeReq(int bookId, String bookAuthor) {
		// TODO Auto-generated method stub
		return false;
	}

	public Book searchBook(int bookId) {

		Book book = new Book();
		try(FileInputStream	fis = new FileInputStream("database.properties")){

			Properties pro = new Properties();
			pro.load(fis);

			Class.forName(pro.getProperty("driver")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro.getProperty("user"),pro.getProperty("password"))){
				String query = pro.getProperty("searchBookId");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setInt(1, bookId);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						book.setBookId(rs.getInt("bookId"));
						book.setBookName(rs.getString("bookName"));
						book.setBookAuthor(rs.getString("bookAuthor"));
						book.setBookPublisher(rs.getString("bookPublisher"));
					
						return book;
					} else {
						System.out.println("book not found");
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Book borrowBook(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean returnBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

}
