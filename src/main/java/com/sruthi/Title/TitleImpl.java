package com.sruthi.Title;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.Logger;

public class TitleImpl implements TitleDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addTitle(Title title) throws Exception {
		String sql = "insert into titles(title_id,pub_id,author_id,sub_id,pub_date,title,version_number,price)values(title_id_seq.nextVal,?,?,?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
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
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
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
		String sql = "select title,price,version_number from titles";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	String title = rs.getString("title");
	    	int price = rs.getInt("price");
	    	int versionNumber = rs.getInt("version_number");
	    	LOGGER.debug("title: "+title+"\nprice: "+price+"\nversion: "+versionNumber);
	    	
	    	Title t = new Title();
	    	list.add(t);	
	    }
		return list;
	}
	@Override
	public void deleteTitle(int titleId) throws Exception {
		String sql = "Delete from titles where title_id = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1, titleId);
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
	}

	
		
		
		

}
