package com.sruthi.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.AuthorDAO;
import com.sruthi.model.Author;

public class AuthorImpl implements AuthorDAO {
	
	private static final Logger LOGGER = Logger.getInstance();

	@Override
	public void addAuthor(Author author)  {
		String sql = "insert into authors1(author_id,author_name,author_mail_id,author_ph) values(author_id_seq.nextVal,?,?,?)";
		
	    
	    try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, author.getAuthorName());
			pst.setString(2, author.getAuthorMailId());
			pst.setLong(3, author.getAuthorPhNo());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted:"+rows);
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
	 
	}

	public List<Author> displayNumberOfAuthors()  {
		List<Author> a = new ArrayList<>();
		String sql = "select author_id,author_name,author_mail_id,author_ph from authors1";
	
	    try(Connection connection = ConnectionUtil.getConnection();Statement stmt=connection.createStatement()) {
	    	try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorMailId = rs.getString("author_mail_id");
				long authorPhNo = rs.getLong("author_ph");
				Author author = new Author();
				author.setAuthorId(authorId);
				author.setAuthorName(authorName);
				author.setAuthorMailId(authorMailId);
				author.setAuthorPhNo(authorPhNo);
				LOGGER.debug("Author-Id : "+authorId+"Author name : "+authorName+"\nAuthor Mail-id : "+authorMailId+"\nAuthor Ph-no : "+authorPhNo);
				a.add(author);
			}
	    	}
		} catch (Exception e) {
		 LOGGER.debug(e);
		}
		
		return a;
	}

	@Override
	public void updateAuthor(Author author)  {
		String sql = "update authors1 set author_mail_id = ?,author_ph = ? where author_id = ?";
		
		
        try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setString(1, author.getAuthorMailId());
			pst.setLong(2, author.getAuthorPhNo());
			pst.setInt(3, author.getAuthorId());
			
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows updated:"+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}

	@Override
	public void deleteAuthor(int authorId) {
		String sql = "Delete authors1 where author_id = ?";
		
		
        try (Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql)){
			pst.setInt(1, authorId);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted:"+rows);
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		
		
	}

	
	

}
