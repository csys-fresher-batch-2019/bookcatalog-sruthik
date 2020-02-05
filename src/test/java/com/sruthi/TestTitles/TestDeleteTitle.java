package com.sruthi.TestTitles;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.dao.TitleDAO;


public class TestDeleteTitle {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Title-id : ");
		int id = in.nextInt();
//		TitleImpl t = new TitleImpl();
//		t.deleteTitle(id);
		TitleDAO dao = DAOFactory.getTitleDAO();
		try {
			dao.deleteTitle(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();

	}

}
