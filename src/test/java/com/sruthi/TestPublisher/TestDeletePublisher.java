package com.sruthi.TestPublisher;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Publisher.PublisherDAO;

public class TestDeletePublisher {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Publisher-id : ");
		int id = in.nextInt();
       PublisherDAO obj = DAOFactory.getPublisherDAO();
       obj.deletePublisher(id);
	
       in.close();
	}

}
