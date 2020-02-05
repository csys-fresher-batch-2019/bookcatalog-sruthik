package com.sruthi.TestAuthor;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.AuthorDAO;


public class TestDeleteAuthor {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Author-id : ");
		int id = in.nextInt();
//        AuthorImpl a = new AuthorImpl();
//        a.deleteAuthor(id);
		AuthorDAO dao = DAOFactory.getAuthorDAO();
	       try {
			dao.deleteAuthor(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        in.close();
	}

}
