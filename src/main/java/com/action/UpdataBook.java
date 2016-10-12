package com.action;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdataBook extends ActionSupport{
	private Book book = new Book();
	public String addBook() {
		HttpServletRequest request =ServletActionContext.getRequest();
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		String authorId = request.getParameter("authorid");
		double price = Double.parseDouble(request.getParameter("price"));
		String temp = request.getParameter("publishdate");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date date = new java.util.Date();
		try {
			date = format.parse(temp.replaceAll("-", ""));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Date publishdate = new Date(date.getTime());
		System.out.print(authorId);
		String sql = "INSERT INTO Book ( ISBN,Title,AuthorID,Publisher,Publishdate,Price) "
				+ "VALUES ('"+isbn+"', '"+title+"', '"+authorId+"', '"+publisher+"', '"+publishdate+"','"+price+"')";
		DBconnect mysqlConnect = new DBconnect();
		try {
			Statement stmt = mysqlConnect.connect().createStatement();
			stmt.execute("SET FOREIGN_KEY_CHECKS=0");
			stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		sql = "SELECT AuthorID FROM Author WHERE AuthorID='"+authorId+"';";
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				return INPUT;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				Statement stmt = mysqlConnect.connect().createStatement();
				stmt.execute("SET FOREIGN_KEY_CHECKS=1");
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mysqlConnect.disconnect();
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	public String up() {
		HttpServletRequest request =ServletActionContext.getRequest();
		String isbn = request.getParameter("isbn");
		String publisher = request.getParameter("publisher");
		String authorId = request.getParameter("authorid");
		double price = Double.parseDouble(request.getParameter("price"));
		String temp = request.getParameter("publishdate");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date date = new java.util.Date();
		try {
			date = format.parse(temp.replaceAll("-", ""));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Date publishdate = new Date(date.getTime());
		//Date publishdate = new Date(Integer.parseInt(longDate[0]), Integer.parseInt(longDate[1]), Integer.parseInt(longDate[2]));
		System.out.print(authorId);
		String sql = "UPDATE Book SET Publisher = '"+publisher+"',Publishdate='"+publishdate+"',Price='"
				+price+"',AuthorId='"+authorId+"' WHERE ISBN = '"+isbn+"';";
		DBconnect mysqlConnect = new DBconnect();
		try {
			Statement stmt = mysqlConnect.connect().createStatement();
			stmt.execute("SET FOREIGN_KEY_CHECKS=0");
			stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		sql = "SELECT AuthorID FROM Author WHERE AuthorID='"+authorId+"';";
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (!resultSet.next()) {
				return INPUT;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				Statement stmt = mysqlConnect.connect().createStatement();
				stmt.execute("SET FOREIGN_KEY_CHECKS=1");
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mysqlConnect.disconnect();
		}
		return SUCCESS;
	}
}
