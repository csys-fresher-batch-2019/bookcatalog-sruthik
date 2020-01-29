package com.sruthi.TestSubject;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Subject.SubjectDAO;
import com.sruthi.Subject.SubjectImpl;

public class TestDeleteSubject {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		LOGGER.getInput("Enter Subject-id : ");
		int id = in.nextInt();
//		SubjectImpl obj = new SubjectImpl();
//        obj.deleteSubject(id);
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		dao.deleteSubject(id);
        in.close();
	}

}
