package com.sruthi;

import com.sruthi.dao.AuthorDAO;
import com.sruthi.dao.CourseTitleDAO;
import com.sruthi.dao.PublisherDAO;
import com.sruthi.dao.SubjectDAO;
import com.sruthi.dao.TitleDAO;
import com.sruthi.dao.UserDAO;
import com.sruthi.impl.AuthorImpl;
import com.sruthi.impl.CourseTitleImpl;
import com.sruthi.impl.PublisherImpl;
import com.sruthi.impl.SubjectImpl;
import com.sruthi.impl.TitleImpl;
import com.sruthi.impl.UserImpl;

public class DAOFactory {
	private DAOFactory() {
	    throw new IllegalStateException("Utility class");
	  }
	
	public static AuthorDAO getAuthorDAO() {
	return new AuthorImpl();
	}
	public static PublisherDAO getPublisherDAO() {
		
		return new PublisherImpl();
		}
	public static SubjectDAO getSubjectDAO() {
		
		return new SubjectImpl();
		}
	public static TitleDAO getTitleDAO() {
		
		return new TitleImpl();
		}
	public static CourseTitleDAO getCourseTitleDAO() {
		
		return new CourseTitleImpl();
		}
	public static UserDAO getUserDAO() {
		
		return new UserImpl();
		}
	

}
