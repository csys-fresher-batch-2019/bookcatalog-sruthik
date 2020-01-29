package com.sruthi.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.Logger;

public class SubjectImpl implements SubjectDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addSubject(Subject sub) throws Exception {
		String sql = "insert into subjects(sub_id,sub_name)values(sub_id_seq.nextVal,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setString(1,sub.getSubName().toString());
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted:"+rows);

	}

	@Override
	public List<Subject> displaySubjectwiseTitles() throws Exception {
		List<Subject> list = new ArrayList<Subject>();
		
		String sql = "select sub_id,sub_name from subjects";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	String subName = rs.getString("sub_name");
	    	int subId = rs.getInt("sub_id");
	    	LOGGER.debug("Subject Name : "+subName+"\nSubject Id : "+subId);
	    	
	    	
	    	Subject sub = new Subject();
	    	
	    	list.add(sub);
 	
	    }
		
		return list;
	}

	

	@Override
	public void updateSubject(Subject sub) throws Exception {
		String sql = "update subjects set sub_name = ?where sub_id = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setString(1, sub.getSubName().toString());
	    pst.setInt(2, sub.getSubId());
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows updated:"+rows);
	
	}

	@Override
	public void deleteSubject(int subId) throws Exception {
		String sql = "Delete from subjects where sub_id = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1,subId);
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
	
	}

}
