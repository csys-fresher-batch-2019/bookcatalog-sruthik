package com.sruthi.TestAuthor;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Author.Author;
import com.sruthi.Author.AuthorDAO;

public class TestUpdateAuthor {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Author a = new Author();
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Author-id : ");
		int id = in.nextInt();
		a.setAuthorId(id);
		LOGGER.getInput("Enter Author mail-id : ");
		String mail = in.next();
		a.setAuthorMailId(mail);
		LOGGER.getInput("Enter Author ph-no : ");
		String phone = in.next();
		a.setAuthorPhNo(phone);
//		AuthorImpl daoImpl = new AuthorImpl();
//		daoImpl.updateAuthor(a);
		AuthorDAO dao = DAOFactory.getAuthorDAO();
	       dao.updateAuthor(a);
		in.close();
		
	}

}
