package com.sruthi.TestTitles;

import com.sruthi.DAOFactory;
import com.sruthi.Title.TitleDAO;

public class TestDisplayTitlesWithPrice {

	public static void main(String[] args) throws Exception {
//		TitleImpl t = new TitleImpl();
//		t.displayTitleWithPrice();
		TitleDAO dao = DAOFactory.getTitleDAO();
		dao.displayTitleWithPrice();
	}

}
