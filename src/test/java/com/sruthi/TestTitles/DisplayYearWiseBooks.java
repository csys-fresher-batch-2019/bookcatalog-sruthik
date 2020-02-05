package com.sruthi.TestTitles;

import java.time.LocalDate;
import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.dao.TitleDAO;

public class DisplayYearWiseBooks {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Published-Date : ");
		LocalDate date = LocalDate.parse(in.next());
		TitleDAO dao = DAOFactory.getTitleDAO();
		try {
			dao.displayYearWiseBooks(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();

	}

}
