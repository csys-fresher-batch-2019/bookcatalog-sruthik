package com.sruthi.TestTitles;

import com.sruthi.DAOFactory;
import com.sruthi.dao.TitleDAO;

public class DisplayBooksPublishedByIndividualPublishers {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TitleDAO dao = DAOFactory.getTitleDAO();
		try {
			dao.displayBooksPublishedByIndividualPublishers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
