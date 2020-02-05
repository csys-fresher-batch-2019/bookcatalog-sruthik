package com.sruthi.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.TitleDAO;
import com.sruthi.model.Title;

public class TitleImpl implements TitleDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addTitle(Title title) throws Exception {
		String sql = "insert into titles(title_id,pub_id,author_id,sub_id,pub_date,title,version_number,price)values(title_id_seq.nextVal,?,?,?,?,?,?,?)";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1, title.getPubId());
	    pst.setInt(2, title.getAuthorId());
	    pst.setInt(3, title.getSubId());
	    pst.setDate(4, Date.valueOf(title.getPubDate()));
	    pst.setString(5, title.getTitle()); 
	    pst.setInt(6, title.getVersionNumber()); 
	    pst.setInt(7, title.getPrice());
	   
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted:"+rows);
	}

	@Override
	public void ChangePubDate(Title title) throws Exception {
		String sql = "Update titles set pub_date = ? where title = ? and version_number = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setDate(1,Date.valueOf(title.getPubDate()));
	    pst.setString(2, title.getTitle());
	    pst.setInt(3, title.getVersionNumber());
	    int rows = pst.executeUpdate();
	    LOGGER.info("No of rows updated:"+rows);	
	}
	@Override
	public List<Title> displayTitleWithPrice() throws Exception {
		List<Title> list = new ArrayList<Title>();
		String sql = "select title,price,version_number,pub_date,title_id,pub_id,author_id,sub_id from titles";
		Connection connection = ConnectionUtil.getConnection();
	    Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	int titleId = rs.getInt("title_id");
	    	int pubId = rs.getInt("pub_id");
	    	int authorId = rs.getInt("author_id");
	    	String title = rs.getString("title");
	    	int price = rs.getInt("price");
	    	int versionNumber = rs.getInt("version_number");
	    	LocalDate date = rs.getDate("pub_date").toLocalDate();
	    	LOGGER.debug("title-id: "+titleId+"pub-id : "+pubId+"Author-id : "+authorId+"title: "+title+"\nprice: "+price+"\nversion: "+versionNumber+"Published-date: "+date);
	    	
	    	Title t = new Title();
	    	
	    	t.setTitle(title);
	    	t.setPrice(price);
	    	t.setVersionNumber(versionNumber);
	    	t.setPubDate(date);
	    	
	    	list.add(t);
	    	
	    }
		return list;
	}
	@Override
	public void deleteTitle(int titleId) throws Exception {
		String sql = "Delete from titles where title_id = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1, titleId);
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
	}

	

	public List<Title> displayTitleForCourseId(int courseId) throws Exception {
		
		String sql = "select title,version_number,price,course_id from titles t INNER JOIN course_titles c ON t.title_id = c.title_id where course_id = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1,courseId);
	    ResultSet rs = pst.executeQuery();
	    List<Title> list = new ArrayList<Title>();
	    while(rs.next()) {
	    	
	    	String name = rs.getString("title");
	    	int versionNumber = rs.getInt("version_number");
	    	int price = rs.getInt("price");
	    	Title t = new Title();
	    	t.setTitle(name);
	    	t.setVersionNumber(versionNumber);
	    	t.setPrice(price);
	    	list.add(t);
	    	//LOGGER.debug("Title-id : "+titleId+"\nPublisher-id : "+pubId+"\nAuthor-id : "+authorId+"\ntitle: "+title+"\nprice: "+price+"\nversion: "+versionNumber);
	    }
	    return list;
	    
		
		
	}

	@Override
	public List<Title> displayYearWiseBooks(LocalDate pubDate) throws Exception {
		List<Title> list = new ArrayList<Title>();
		String sql = "select title from titles where to_char(pub_date,'yyyy') = ?";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, pubDate.getYear());
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String title = rs.getString("title");
			LOGGER.debug("Title: "+title);
		}
		
		return list;
	}

	@Override
	public List<Title> displayBooksPublishedByIndividualPublishers() throws Exception {
		// TODO Auto-generated method stub
		List<Title> list = new ArrayList<Title>();
		String sql = "select pub_name, count(*) as count from   publishers p, titles t where  p.pub_id = t.pub_id group  by pub_name";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String pubName = rs.getString("pub_name");
			int count = rs.getInt("count");
			LOGGER.debug("Publisher-Name : "+pubName+"\nNo of books Published : "+count);
			
		}
		
		return list;
	}

	@Override
	public List<Title> displayByRecentBooks()  {
		// TODO Auto-generated method stub
		List<Title> list = new ArrayList<>();
		String sql = "select title,price,pub_date from titles order by pub_date desc";
		
		
		    try(Connection connection = ConnectionUtil.getConnection(); Statement stmt=connection.createStatement()) {
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					String title = rs.getString("title");
					int price = rs.getInt("price");
					LocalDate date = rs.getDate("pub_date").toLocalDate();
					Title t = new Title();
					t.setTitle(title);
					t.setPrice(price);
					t.setPubDate(date);
					list.add(t);
					
					
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return list;
	}

	
		
		
		

}
