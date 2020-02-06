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
import com.sruthi.dao.CourseTitleDAO;
import com.sruthi.model.CourseTitles;

public class CourseTitleImpl implements CourseTitleDAO{
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public void addCourseTitle(CourseTitles course)  {
		
		String sql = "insert into course_titles(course_id,title_id)values(?,?)";
		try(Connection connection = ConnectionUtil.getConnection();
			    PreparedStatement pst = connection.prepareStatement(sql)
			    ) {
			pst.setInt(1,course.getCourseId());
			pst.setInt(2, course.getTitleId());
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted:"+rows);
		} catch (Exception e) {
			LOGGER.debug(e);
		}
		
	}

	@Override
	public void deleteCourseTitle(int courseId)  {
		
		String sql = "Delete from course_titles where course_id = ?";
		try(Connection connection = ConnectionUtil.getConnection();
			    PreparedStatement pst = connection.prepareStatement(sql)
			    ) {
			pst.setInt(1,courseId);
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted:"+rows);
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		
	}

	public void updateCourseTitle(CourseTitles course) {
		
		String sql = "Update course_titles set course_id = ? where title_id = ?";
		try(Connection connection = ConnectionUtil.getConnection();
			    PreparedStatement pst = connection.prepareStatement(sql)
			    ) {
			pst.setInt(1,course.getCourseId());
			pst.setInt(2,course.getTitleId() );
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows deleted:"+rows);
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		
	}

	@Override
	public List<CourseTitles> displayCourseTitles()  {
		
		List<CourseTitles> list = new ArrayList<>();
		String sql = "select course_id,title_id from course_titles";
		try(Connection connection = ConnectionUtil.getConnection();
				Statement stmt=connection.createStatement()
			    ) {
			
			try(ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				int courseId = rs.getInt("course_id");
				int titleId = rs.getInt("title_id");
				CourseTitles course = new CourseTitles();
				course.setCourseId(courseId);
				course.setTitleId(titleId);
				list.add(course);
			}
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
		}
		
		return list;
	}

}
