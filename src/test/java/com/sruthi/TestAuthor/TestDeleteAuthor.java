package com.sruthi.TestAuthor;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Author.AuthorDAO;


public class TestDeleteAuthor {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Author-id : ");
		int id = in.nextInt();
//        AuthorImpl a = new AuthorImpl();
//        a.deleteAuthor(id);
		AuthorDAO dao = DAOFactory.getAuthorDAO();
	       dao.deleteAuthor(id);
        in.close();
	}

}
