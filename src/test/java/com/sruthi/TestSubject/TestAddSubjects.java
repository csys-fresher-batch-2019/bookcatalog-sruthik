package com.sruthi.TestSubject;

import java.util.Scanner;


import com.sruthi.DAOFactory;
import com.sruthi.dao.SubjectDAO;
import com.sruthi.model.Subject;


public class TestAddSubjects {

	public static void main(String[] args)  {
		Subject s = new Subject();
		Scanner in = new Scanner(System.in);
		s.setSubName(in.next());
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		try {
			dao.addSubject(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
	}

}
