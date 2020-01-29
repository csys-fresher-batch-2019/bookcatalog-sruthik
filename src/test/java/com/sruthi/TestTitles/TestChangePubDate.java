package com.sruthi.TestTitles;

import java.time.LocalDate;
import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Title.Title;
import com.sruthi.Title.TitleDAO;
import com.sruthi.Title.TitleImpl;

public class TestChangePubDate {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Title t = new Title();
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Published-Date : ");
		LocalDate date = LocalDate.parse(in.next());
		t.setPubDate(date);
		LOGGER.getInput("Enter Title : ");
		String title = in.next();
		t.setTitle(title);
		LOGGER.getInput("Enter Version-number : ");
		int version = in.nextInt();
		t.setVersionNumber(version);
	
//		TitleImpl daoImpl = new TitleImpl();
//		daoImpl.ChangePubDate(t);
		TitleDAO dao = DAOFactory.getTitleDAO();
		dao.ChangePubDate(t);
		in.close();
		

	}

}
