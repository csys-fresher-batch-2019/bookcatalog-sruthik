package com.sruthi.TestAuthor;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.AuthorDAO;
import com.sruthi.model.Author;

public class TestUpdateAuthor {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
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
	       try {
			dao.updateAuthor(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		
	}

}
