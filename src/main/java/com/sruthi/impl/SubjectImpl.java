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
import com.sruthi.dao.SubjectDAO;
import com.sruthi.model.Subject;

public class SubjectImpl implements SubjectDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addSubject(Subject sub)  {
		String sql = "insert into subjects(sub_id,sub_name)values(sub_id_seq.nextVal,?)";
		try(Connection connection = ConnectionUtil.getConnection();
			    PreparedStatement pst = connection.prepareStatement(sql)
			    ) {
			pst.setString(1,sub.getSubName().toString());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted:"+rows);

		} catch (SQLException e) {
			LOGGER.debug(e);
		}
	    
	}

	@Override
	public List<Subject> displaySubjectwiseTitles()  {
		List<Subject> list = new ArrayList<>();
		
		String sql = "select sub_id,sub_name from subjects";
		try(Connection connection = ConnectionUtil.getConnection();
			    Statement stmt=connection.createStatement()
			    ){
			try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				
				int subId = rs.getInt("sub_id");
				String subName = rs.getString("sub_name");
				LOGGER.debug("Subject Id : "+subId+"\nSubject Name : "+subName);
				
				
				Subject sub = new Subject();
				sub.setSubId(subId);
				sub.setSubName(subName);
				
				list.add(sub);
	
			}
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		
		return list;
	}

	

	@Override
	public void updateSubject(Subject sub) {
		String sql = "update subjects set sub_name = ?where sub_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
			    PreparedStatement pst = connection.prepareStatement(sql)
			    ){
			pst.setString(1, sub.getSubName().toString());
			pst.setInt(2, sub.getSubId());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows updated:"+rows);
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
	
	}

	@Override
	public void deleteSubject(int subId)  {
		String sql = "Delete from subjects where sub_id = ?";
		
	    try(Connection connection = ConnectionUtil.getConnection();
	    	    PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1,subId);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted:"+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
	
	}

}
