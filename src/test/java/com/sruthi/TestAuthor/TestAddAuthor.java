package com.sruthi.TestAuthor;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.AuthorDAO;
import com.sruthi.model.Author;

public class TestAddAuthor {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		
	   Author a = new Author();
	   Scanner in = new Scanner(System.in);
	   LOGGER.getInput("Enter AuthorName: ");
       a.setAuthorName(in.next());
       LOGGER.getInput("Enter Author mail-id: ");
       a.setAuthorMailId(in.next());
       LOGGER.getInput("Enter Author Ph-no: ");
       a.setAuthorPhNo(in.next());
       
//       AuthorImpl daoImpl = new AuthorImpl();
//       daoImpl.addAuthor(a);
       AuthorDAO dao = DAOFactory.getAuthorDAO();  
		dao.addAuthor(a);
 
//		System.out.println("Enter Author-id : ");
//		int id = in.nextInt();
//       dao.deleteAuthor(id);
       
       in.close();
	}

}
