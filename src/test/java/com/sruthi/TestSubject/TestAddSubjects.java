package com.sruthi.TestSubject;

import com.sruthi.CheckSubjectEnum;
import com.sruthi.DAOFactory;
import com.sruthi.dao.SubjectDAO;
import com.sruthi.model.Subject;


public class TestAddSubjects {

	public static void main(String[] args)  {
		Subject s = new Subject();
		
		CheckSubjectEnum name = CheckSubjectEnum.English;
		s.setSubName(name);
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		try {
			dao.addSubject(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
