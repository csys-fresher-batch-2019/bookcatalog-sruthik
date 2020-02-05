package com.sruthi.TestSubject;

import java.util.Scanner;

import com.sruthi.CheckSubjectEnum;
import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.dao.SubjectDAO;
import com.sruthi.model.Subject;

public class TestUpdateSubject {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args)  {
		
		Subject s = new Subject();
		Scanner in = new Scanner(System.in);
		LOGGER.info("Enter Subject-id : ");
		int id= in.nextInt();
		s.setSubId(id);
		LOGGER.info("Enter Subject-Name : ");
		
		CheckSubjectEnum name = CheckSubjectEnum.English;
		s.setSubName(name);
		
//		SubjectImpl daoImpl = new SubjectImpl();
//		daoImpl.updateSubject(s);
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		try {
			dao.updateSubject(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}
}
