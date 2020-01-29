package com.sruthi.Author;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.Logger;

public class AuthorImpl implements AuthorDAO {
	
	private static final Logger LOGGER = Logger.getInstance();

	@Override
	public void addAuthor(Author author) throws Exception {
		String sql = "insert into authors1(author_id,author_name,author_mail_id,author_ph) values(author_id_seq.nextVal,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setString(1, author.getAuthorName());
	    pst.setString(2, author.getAuthorMailId());
	    pst.setString(3, author.getAuthorPhNo());
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted:"+rows);
	    
		
	}

	public List<Author> displayNumberOfAuthors() throws Exception {
		List<Author> a = new ArrayList<Author>();
		String sql = "select author_name,author_mail_id,author_ph from authors1";
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	
	    	String authorName = rs.getString("author_name");
	    	String authorMailId = rs.getString("author_mail_id");
	    	String authorPhNo = rs.getString("author_ph");
	    	
	    	
	    	Author author = new Author();
	    	author.setAuthorName(authorName);
	    	author.setAuthorMailId(authorMailId);
	    	author.setAuthorPhNo(authorPhNo);
	    	LOGGER.debug("Author name : "+authorName+"\nAuthor Mail-id : "+authorMailId+"\nAuthor Ph-no : "+authorPhNo);
			a.add(author);
	    }
		
		return a;
	}

	@Override
	public void updateAuthor(Author author) throws Exception {
		String sql = "update authors1 set author_mail_id = ?,author_ph = ? where author_id = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, author.getAuthorMailId());
        pst.setString(2, author.getAuthorPhNo());
        pst.setInt(3, author.getAuthorId());
		
		int rows = pst.executeUpdate();
		LOGGER.info("No of rows updated:"+rows);
		
	}

	@Override
	public void deleteAuthor(int authorId) throws Exception {
		String sql = "Delete authors1 where author_id = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, authorId);
        int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
		
		
	}

	
	

}
