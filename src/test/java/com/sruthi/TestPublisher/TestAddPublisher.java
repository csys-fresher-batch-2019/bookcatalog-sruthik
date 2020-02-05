package com.sruthi.TestPublisher;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.PublisherDAO;
import com.sruthi.model.Publisher;

public class TestAddPublisher {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Publisher p = new Publisher();
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Publisher-Name : ");
		String name = in.next();
		p.setPubName(name);
		LOGGER.getInput("Enter Publisher mail-id : ");
		String mail = in.next();
		p.setPubMailId(mail);
		LOGGER.getInput("Enter Publisher ph-no : ");
		String phone = in.next();
		p.setPubPhNo(phone);
		
		PublisherDAO dao = DAOFactory.getPublisherDAO();
		try {
			dao.addPublisher(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}

}
