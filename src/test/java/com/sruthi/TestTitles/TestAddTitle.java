package com.sruthi.TestTitles;

import java.time.LocalDate;
import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Title.Title;
import com.sruthi.Title.TitleDAO;

public class TestAddTitle {
	private static final Logger LOGGER = Logger.getInstance();
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
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
		dao.addTitle(t);
		in.close();
		

	}

}
