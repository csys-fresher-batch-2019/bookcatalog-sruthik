package com.sruthi.TestPublisher;

import com.sruthi.DAOFactory;
import com.sruthi.Publisher.PublisherDAO;

public class TestDisplayPublishers {

	public static void main(String[] args) throws Exception{
		
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		dao.displayPubId();
		
		

	}

}
