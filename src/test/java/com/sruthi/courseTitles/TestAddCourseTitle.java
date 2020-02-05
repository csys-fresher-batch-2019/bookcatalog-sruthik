package com.sruthi.courseTitles;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.CourseTitleDAO;
import com.sruthi.model.CourseTitles;

public class TestAddCourseTitle {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CourseTitles c = new CourseTitles();
         Scanner in = new Scanner(System.in);
         LOGGER.debug("Enter course-id : ");
         int id = in.nextInt();
         c.setCourseId(id);
         LOGGER.debug("Enter title-id : ");
         int id1 = in.nextInt();
         c.setTitleId(id1);
         CourseTitleDAO dao = DAOFactory.getCourseTitleDAO();
         dao.addCourseTitle(c);
         //dao.deleteCourseTitle(id);
         
         //dao.displayCourseTitles();
         //dao.updateCourseTitle(c);
         in.close();
        		 
         
         
         
	}

}
