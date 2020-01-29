package com.sruthi.TestAuthor;

import com.sruthi.DAOFactory;
import com.sruthi.Author.AuthorDAO;

public class TestListAuthors {

	public static void main(String[] args) throws Exception {
//		AuthorImpl a = new AuthorImpl();
//		a.displayNumberOfAuthors();
		AuthorDAO dao = DAOFactory.getAuthorDAO();
	       dao.displayNumberOfAuthors();

	}

}
