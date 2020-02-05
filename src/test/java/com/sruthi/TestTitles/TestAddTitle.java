package com.sruthi.TestTitles;

import java.time.LocalDate;
import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.TitleDAO;
import com.sruthi.model.Title;

public class TestAddTitle {
	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
		Title t = new Title();
		Scanner in = new Scanner(System.in);
		
		LOGGER.getInput("Enter Author-id : ");
		int id = in.nextInt();
		t.setAuthorId(id);
		LOGGER.getInput("Enter Publisher-id : ");
		int pubId = in.nextInt();
		t.setPubId(pubId);
		LOGGER.getInput("Enter Subject-id : ");
		int subId = in.nextInt();
		t.setSubId(subId);
		LOGGER.getInput("Enter Published-Date : ");
		LocalDate date = LocalDate.parse(in.next());
		t.setPubDate(date);
		LOGGER.getInput("Enter title : ");
		String title = in.next();
		t.setTitle(title);
		LOGGER.getInput("Enter Version-Number : ");
		int version = in.nextInt();
		t.setVersionNumber(version);
		LOGGER.getInput("Enter Price : ");
		int price = in.nextInt();
		t.setPrice(price);
		TitleDAO dao = DAOFactory.getTitleDAO();
		try {
			dao.addTitle(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		

	}

}
