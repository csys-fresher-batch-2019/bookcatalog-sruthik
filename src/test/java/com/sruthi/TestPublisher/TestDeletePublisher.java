package com.sruthi.TestPublisher;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.PublisherDAO;

public class TestDeletePublisher {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Publisher-id : ");
		int id = in.nextInt();
       PublisherDAO obj = DAOFactory.getPublisherDAO();
       try {
		obj.deletePublisher(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
       in.close();
	}

}
