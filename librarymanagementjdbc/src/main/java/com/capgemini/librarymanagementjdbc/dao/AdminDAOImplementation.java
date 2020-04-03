package com.capgemini.librarymanagementjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.capgemini.librarymanagementjdbc.dto.Book;

public class AdminDAOImplementation implements AdminDAO {

	public int addBook(Book book) {
		int count = 0;
		try {
			try(FileInputStream fin = new FileInputStream("database.properties")) {

				Properties pro = new Properties();
				pro.load(fin);

				Class.forName(pro.getProperty("driver"));

				try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro.getProperty("user"),pro.getProperty("password"));){

					String query = pro.getProperty("addBook");
					try(PreparedStatement pstmt = conn.prepareStatement(query);){
						pstmt.setInt(1, book.getBookId());
						pstmt.setString(2, book.getBookName());
						pstmt.setString(3, book.getBookAuthor());
						pstmt.setString(4, book.getBookPublisher());
						count = pstmt.executeUpdate();					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	} 

	public int removeBook(int bookId) {
		int count = 0;
		try {
			try(FileInputStream fis = new FileInputStream("database.properties")){
				Properties pro = new Properties();
				pro.load(fis);

				Class.forName(pro.getProperty("driver")).newInstance();


				try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro.getProperty("user"),pro.getProperty("password"));) {
					String query = pro.getProperty("removeBook");

					try(PreparedStatement pstmt = conn.prepareStatement(query);){
						pstmt.setInt(1, bookId);
						count = pstmt.executeUpdate();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public boolean issueBook(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

}
