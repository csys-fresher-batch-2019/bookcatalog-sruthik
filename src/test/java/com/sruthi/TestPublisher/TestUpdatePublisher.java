package com.sruthi.TestPublisher;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Publisher.Publisher;
import com.sruthi.Publisher.PublisherDAO;

public class TestUpdatePublisher {
	private static final Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) throws Exception {
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
		String phone = in.next();
		p.setPubPhNo(phone);
//		PublisherImpl obj = new PublisherImpl();
//		obj.updateMailIdAndPhNo(p);
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		dao.updateMailIdAndPhNo(p);
		in.close();

	}

}
