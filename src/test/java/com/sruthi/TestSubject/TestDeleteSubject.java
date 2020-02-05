package com.sruthi.TestSubject;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.SubjectDAO;


public class TestDeleteSubject {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Subject-id : ");
		int id = in.nextInt();
//		SubjectImpl obj = new SubjectImpl();
//        obj.deleteSubject(id);
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		try {
			dao.deleteSubject(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        in.close();
	}

}
