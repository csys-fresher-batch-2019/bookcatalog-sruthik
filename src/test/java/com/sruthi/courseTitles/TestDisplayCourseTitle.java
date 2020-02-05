package com.sruthi.courseTitles;



import java.util.List;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.CourseTitleDAO;
import com.sruthi.model.CourseTitles;



public class TestDisplayCourseTitle {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
    CourseTitleDAO dao = DAOFactory.getCourseTitleDAO();
    dao.displayCourseTitles();
    try {
		List<CourseTitles> list = dao.displayCourseTitles();
		for (CourseTitles course : list) {
			LOGGER.debug("Courseid: "+course.getCourseId()+"\ntitleid: "+course.getTitleId());

		}
	} catch (Exception e) {
		e.printStackTrace();
		LOGGER.debug("No Contents to display");
	}
    
	}
    
    

}
