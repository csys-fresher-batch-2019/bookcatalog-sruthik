package com.sruthi.TestPublisher;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.PublisherDAO;
import com.sruthi.model.Publisher;

public class TestUpdatePublisher {
	private static final Logger LOGGER = Logger.getInstance();

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		Publisher p = new Publisher();
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Publisher-id : ");
		int id = in.nextInt();
		p.setPubId(id);
		LOGGER.getInput("Enter Publisher mail-id : ");
		String mail = in.next();
		p.setPubMailId(mail);
		LOGGER.getInput("Enter Publisher ph-no : ");
		p.setPubPhNo(in.next());
//		PublisherImpl obj = new PublisherImpl();
//		obj.updateMailIdAndPhNo(p);
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		try {
			dao.updateMailIdAndPhNo(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();

	}

}
