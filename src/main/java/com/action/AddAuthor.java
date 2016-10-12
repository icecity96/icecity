package com.action;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AddAuthor extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String authorId = request.getParameter("authorid");
		System.out.println(authorId);
		int age = Integer.parseInt(request.getParameter("age"));
		String country = request.getParameter("country");
		String name = request.getParameter("name");
		String sql = "INSERT INTO Author ( AuthorID,Age,Country,Name) " + "VALUES ('" + authorId + "', '" + age + "', '"
				+ country + "', '" + name + "')";
		DBconnect mysqlConnect = new DBconnect();
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return SUCCESS;
	}
}
