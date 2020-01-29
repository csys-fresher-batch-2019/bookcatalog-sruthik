package com.sruthi.TestSubject;

import com.sruthi.DAOFactory;
import com.sruthi.Subject.SubjectDAO;

public class TestDisplaySubjectWiseTitles {

	public static void main(String[] args) throws Exception {
//		SubjectImpl obj = new SubjectImpl();
//		obj.displaySubjectwiseTitles();
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		dao.displaySubjectwiseTitles();
	}

}
