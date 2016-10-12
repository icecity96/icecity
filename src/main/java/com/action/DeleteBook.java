package com.action;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;


@SuppressWarnings("serial")
public class DeleteBook extends ActionSupport{
	private Book book = new Book();

	

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}


	public String del() {
		//ISBN = request.getParameter("ISBN");
		String ISBN = book.getISBN();
		String sql = "DELETE FROM Book WHERE ISBN="+"'"+ISBN+"'" +";";
		System.out.println(sql);
		DBconnect mysqlConnect = new DBconnect();
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		
		return SUCCESS;
	}
}
