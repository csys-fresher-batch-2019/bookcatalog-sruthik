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
	public static AuthorDAO getAuthorDAO() {
	AuthorDAO authorDAO = new AuthorImpl();
	return authorDAO;
	}
	public static PublisherDAO getPublisherDAO() {
		PublisherDAO publisherDAO = new PublisherImpl();
		return publisherDAO;
		}
	public static SubjectDAO getSubjectDAO() {
		SubjectDAO subjectDAO = new SubjectImpl();
		return subjectDAO;
		}
	public static TitleDAO getTitleDAO() {
		TitleDAO titleDAO = new TitleImpl();
		return titleDAO;
		}
	public static CourseTitleDAO getCourseTitleDAO() {
		CourseTitleDAO courseTitleDAO = new CourseTitleImpl();
		return courseTitleDAO;
		}
	public static UserDAO getUserDAO() {
		UserDAO userdao = new UserImpl();
		return userdao;
		}
	

}
