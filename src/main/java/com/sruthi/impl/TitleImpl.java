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


import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.TitleDAO;
import com.sruthi.model.Title;

public class TitleImpl implements TitleDAO{
	private static final Logger LOGGER = Logger.getInstance();
	private static final String ACTION_1 = "title";
	private static final String ACTION_2 = "price";
	
	@Override
	public void addTitle(Title title) {
		String sql = "insert into titles(title_id,pub_id,author_id,sub_id,pub_date,title,version_number,price)values(title_id_seq.nextVal,?,?,?,?,?,?,?)";
		
	    try(Connection connection = ConnectionUtil.getConnection();
	    	    PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, title.getPubId());
			pst.setInt(2, title.getAuthorId());
			pst.setInt(3, title.getSubId());
			pst.setDate(4, Date.valueOf(title.getPubDate()));
			pst.setString(5, title.getTitle()); 
			pst.setInt(6, title.getVersionNumber()); 
			pst.setInt(7, title.getPrice());
   
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted:"+rows);
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
	}

	@Override
	public void changePubDate(Title title)  {
		String sql = "Update titles set pub_date = ? where title = ? and version_number = ?";
		
	    try(Connection connection = ConnectionUtil.getConnection();
	    	    PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setDate(1,Date.valueOf(title.getPubDate()));
			pst.setString(2, title.getTitle());
			pst.setInt(3, title.getVersionNumber());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows updated:"+rows);
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}	
	}
	@Override
	public List<Title> displayTitleWithPrice() {
		List<Title> list = new ArrayList<>();
		String sql = "select title,price,version_number,pub_date,title_id,pub_id,author_id,sub_id from titles";
		try(Connection connection = ConnectionUtil.getConnection();
			    Statement stmt=connection.createStatement()
			    ) {
			try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				int titleId = rs.getInt("title_id");
				int pubId = rs.getInt("pub_id");
				int authorId = rs.getInt("author_id");
				String title = rs.getString(ACTION_1);
				int price = rs.getInt(ACTION_2);
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
			}
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
		return list;
	}
	@Override
	public void deleteTitle(int titleId)  {
		String sql = "Delete from titles where title_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql)
	    ){
			pst.setInt(1, titleId);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted:"+rows);
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
	}

	

	public List<Title> displayTitleForCourseId(int courseId)  {
		List<Title>list = new ArrayList<>();
		String sql = "select title,version_number,price,course_id from titles t INNER JOIN course_titles c ON t.title_id = c.title_id where course_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
			    PreparedStatement pst = connection.prepareStatement(sql);
			    ){
			pst.setInt(1,courseId);
				try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()) {
					
					String name = rs.getString(ACTION_1);
					int versionNumber = rs.getInt("version_number");
					int price = rs.getInt(ACTION_2);
					Title t = new Title();
					t.setTitle(name);
					t.setVersionNumber(versionNumber);
					t.setPrice(price);
					list.add(t);
					
				}
				}
		} catch (SQLException e) {
			
			LOGGER.debug(e);
			}
		
	    return list;
	    
		
		
	}

	@Override
	public List<Title> displayYearWiseBooks(LocalDate pubDate) {
		List<Title> list = new ArrayList<>();
		String sql = "select title from titles where to_char(pub_date,'yyyy') = ?";
		try(Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);
				) {
			pst.setInt(1, pubDate.getYear());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String title = rs.getString(ACTION_1);
				LOGGER.debug("Title: "+title);
			}
		} catch (SQLException e) {
			
			LOGGER.debug(e);
		}
		
		return list;
	}

	@Override
	public List<Title> displayBooksPublishedByIndividualPublishers() {
		
		List<Title> list = new ArrayList<>();
		String sql = "select pub_name, count(*) as count from   publishers p, titles t where  p.pub_id = t.pub_id group  by pub_name";
		try(Connection connection = ConnectionUtil.getConnection();PreparedStatement pst = connection.prepareStatement(sql);ResultSet rs = pst.executeQuery()) {
			while(rs.next()) {
				String pubName = rs.getString("pub_name");
				int count = rs.getInt("count");
				LOGGER.debug("Publisher-Name : "+pubName+"\nNo of books Published : "+count);
				
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		return list;
	}

	@Override
	public List<Title> displayByRecentBooks()   {
		List<Title> list = new ArrayList<>();
		String sql = "select title,price,pub_date from titles order by pub_date desc";
		    try(Connection connection = ConnectionUtil.getConnection(); Statement stmt=connection.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
	
				while(rs.next()) {
					String title = rs.getString(ACTION_1);
					int price = rs.getInt(ACTION_2);
					LocalDate date = rs.getDate("pub_date").toLocalDate();
					Title t = new Title();
					t.setTitle(title);
					t.setPrice(price);
					t.setPubDate(date);
					list.add(t);
					
					
				}
			} catch (Exception e) {
				LOGGER.debug(e);
			}
		return list;
	}

	
		
		
		

}
