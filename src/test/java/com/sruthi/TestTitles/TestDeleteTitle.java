package com.sruthi.TestTitles;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Title.TitleDAO;
import com.sruthi.Title.TitleImpl;

public class TestDeleteTitle {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Title-id : ");
		int id = in.nextInt();
//		TitleImpl t = new TitleImpl();
//		t.deleteTitle(id);
		TitleDAO dao = DAOFactory.getTitleDAO();
		dao.deleteTitle(id);
		in.close();

	}

}
