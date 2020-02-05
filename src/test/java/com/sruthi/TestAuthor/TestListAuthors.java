package com.sruthi.TestAuthor;

import com.sruthi.DAOFactory;
import com.sruthi.dao.AuthorDAO;

public class TestListAuthors {

	public static void main(String[] args)  {
//		AuthorImpl a = new AuthorImpl();
//		a.displayNumberOfAuthors();
		AuthorDAO dao = DAOFactory.getAuthorDAO();
	       try {
			dao.displayNumberOfAuthors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
