package com.sruthi.TestSubject;

import java.util.Scanner;

import com.sruthi.DAOFactory;
import com.sruthi.Logger;
import com.sruthi.Subject.CheckSubjectEnum;
import com.sruthi.Subject.Subject;
import com.sruthi.Subject.SubjectDAO;

public class TestUpdateSubject {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws Exception {
		
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
		dao.updateSubject(s);
		in.close();
	}
}
