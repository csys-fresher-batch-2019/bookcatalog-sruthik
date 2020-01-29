package com.sruthi.TestSubject;

import com.sruthi.DAOFactory;
import com.sruthi.Subject.CheckSubjectEnum;
import com.sruthi.Subject.Subject;
import com.sruthi.Subject.SubjectDAO;


public class TestAddSubjects {

	public static void main(String[] args) throws Exception {
		Subject s = new Subject();
		
		CheckSubjectEnum name = CheckSubjectEnum.English;
		s.setSubName(name);
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		dao.addSubject(s);
	}

}
