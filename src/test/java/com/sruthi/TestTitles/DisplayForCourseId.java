package com.sruthi.TestTitles;

import java.util.List;
import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.TitleDAO;
import com.sruthi.model.Title;

public class DisplayForCourseId {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Course-Code : ");
		int id = in.nextInt();
		System.out.println("Recommended Books...");
        TitleDAO dao = DAOFactory.getTitleDAO();
        try {
			List<Title> list = dao.displayTitleForCourseId(id);
			for (Title title : list) {
				LOGGER.debug("title: "+title.getTitle()+"\nprice: "+title.getPrice()+"\nversion: "+title.getVersionNumber());

			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug("No Contents to display");
		}
        in.close();
	}

}
