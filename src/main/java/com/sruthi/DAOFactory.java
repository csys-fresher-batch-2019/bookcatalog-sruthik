package com.sruthi;

import com.sruthi.Author.AuthorDAO;
import com.sruthi.Author.AuthorImpl;
import com.sruthi.Publisher.PublisherDAO;
import com.sruthi.Publisher.PublisherImpl;
import com.sruthi.Subject.SubjectDAO;
import com.sruthi.Subject.SubjectImpl;
import com.sruthi.Title.TitleDAO;
import com.sruthi.Title.TitleImpl;

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
	

}
