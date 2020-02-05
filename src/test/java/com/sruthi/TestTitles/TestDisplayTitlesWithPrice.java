package com.sruthi.TestTitles;

import com.sruthi.DAOFactory;
import com.sruthi.dao.TitleDAO;

public class TestDisplayTitlesWithPrice {

	public static void main(String[] args) {
//		TitleImpl t = new TitleImpl();
//		t.displayTitleWithPrice();
		TitleDAO dao = DAOFactory.getTitleDAO();
		try {
			dao.displayTitleWithPrice();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
