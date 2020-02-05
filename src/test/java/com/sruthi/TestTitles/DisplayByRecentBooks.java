package com.sruthi.TestTitles;



import java.util.List;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.TitleDAO;
import com.sruthi.model.Title;

public class DisplayByRecentBooks {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 TitleDAO dao = DAOFactory.getTitleDAO();
		 dao.displayByRecentBooks();
		 try {
			List<Title> list =dao.displayByRecentBooks();
			 for (Title title : list) {
				LOGGER.debug("Title : "+title.getTitle()+"\nPrice : "+title.getPrice()+"\nPublished-Date : "+title.getPubDate());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
