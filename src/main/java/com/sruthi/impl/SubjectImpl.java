package com.sruthi.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.SubjectDAO;
import com.sruthi.model.Subject;

public class SubjectImpl implements SubjectDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addSubject(Subject sub) throws Exception {
		String sql = "insert into subjects(sub_id,sub_name)values(sub_id_seq.nextVal,?)";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setString(1,sub.getSubName().toString());
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted:"+rows);

	}

	@Override
	public List<Subject> displaySubjectwiseTitles() throws Exception {
		List<Subject> list = new ArrayList<Subject>();
		
		String sql = "select sub_id,sub_name from subjects";
		Connection connection = ConnectionUtil.getConnection();
	    Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	
	    	int subId = rs.getInt("sub_id");
	    	String subName = rs.getString("sub_name");
	    	LOGGER.debug("Subject Id : "+subId+"\nSubject Name : "+subName);
	    	
	    	
	    	Subject sub = new Subject();
	    	sub.setSubId(subId);
	    	sub.setSubName(subName);
	    	
	    	list.add(sub);
 	
	    }
		
		return list;
	}

	

	@Override
	public void updateSubject(Subject sub) throws Exception {
		String sql = "update subjects set sub_name = ?where sub_id = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setString(1, sub.getSubName().toString());
	    pst.setInt(2, sub.getSubId());
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows updated:"+rows);
	
	}

	@Override
	public void deleteSubject(int subId) throws Exception {
		String sql = "Delete from subjects where sub_id = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1,subId);
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
	
	}

}
