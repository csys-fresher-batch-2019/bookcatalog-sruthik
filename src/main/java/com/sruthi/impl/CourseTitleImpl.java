package com.sruthi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.CourseTitleDAO;
import com.sruthi.model.CourseTitles;

public class CourseTitleImpl implements CourseTitleDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addCourseTitle(CourseTitles course) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into course_titles(course_id,title_id)values(?,?)";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1,course.getCourseId());
	    pst.setInt(2, course.getTitleId());
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows inserted:"+rows);
		
	}

	@Override
	public void deleteCourseTitle(int courseId) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Delete from course_titles where course_id = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1,courseId);
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
		
	}

	public void updateCourseTitle(CourseTitles course) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Update course_titles set course_id = ? where title_id = ?";
		Connection connection = ConnectionUtil.getConnection();
	    PreparedStatement pst = connection.prepareStatement(sql);
	    pst.setInt(1,course.getCourseId());
	    pst.setInt(2,course.getTitleId() );
	    int rows = pst.executeUpdate();
		LOGGER.info("No of rows deleted:"+rows);
		
	}

	@Override
	public List<CourseTitles> displayCourseTitles() throws Exception {
		// TODO Auto-generated method stub
		List<CourseTitles> list = new ArrayList<CourseTitles>();
		String sql = "select course_id,title_id from course_titles";
		Connection connection = ConnectionUtil.getConnection();
		Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	int courseId = rs.getInt("course_id");
	    	int titleId = rs.getInt("title_id");
	    	CourseTitles course = new CourseTitles();
	    	course.setCourseId(courseId);
	    	course.setTitleId(titleId);
	    	list.add(course);
	    }
		return list;
	}

}
