package com.sruthi.TestPublisher;

import com.sruthi.DAOFactory;
import com.sruthi.dao.PublisherDAO;

public class TestDisplayPublishers {

	public static void main(String[] args) {
		
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		try {
			dao.displayPubId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
