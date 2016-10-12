package com.action;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchAuthor extends ActionSupport{
	private List<Book> result;
	public List<Book> getResult() {
		return result;
	}
	public void setResult(List<Book> result) {
		this.result = result;
	}
	public String getTitlesByName() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		System.out.println(name);
		String sql = "SELECT Title,ISBN,PublishDate,Publisher,Price,Author.AuthorID,Name,Age,Country" + " FROM Book,Author" + 
				" WHERE Book.AuthorID=Author.AuthorID and Author.Name = ?";
		DBconnect mysqlConnect = new DBconnect();
		result = new ArrayList<Book>();
		try {
			PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Book temp = new Book();
				temp.setISBN(resultSet.getString("ISBN"));
				temp.setTiltle(resultSet.getString("Title"));
				temp.setPublisher(resultSet.getString("Publisher"));
				temp.setPublishDate(resultSet.getDate("PublishDate"));
				temp.setPrice(resultSet.getDouble("Price"));
				Author author = new Author();
				author.setAge(resultSet.getInt("Age"));
				author.setAuthorId(resultSet.getString("Author.AuthorID"));
				author.setCountry(resultSet.getString("Country"));
				author.setName(resultSet.getString("Name"));
				temp.setAuthor(author);
				result.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		if (result.isEmpty()) {
			request.getSession().setAttribute("msg", "不存在该作者或该作者无图书");
			return "failure";
		}
		return SUCCESS;
	}
}
