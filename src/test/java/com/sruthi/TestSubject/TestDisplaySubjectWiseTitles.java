package com.sruthi.TestSubject;

import com.sruthi.DAOFactory;
import com.sruthi.dao.SubjectDAO;

public class TestDisplaySubjectWiseTitles {

	public static void main(String[] args)  {
//		SubjectImpl obj = new SubjectImpl();
//		obj.displaySubjectwiseTitles();
		SubjectDAO dao = DAOFactory.getSubjectDAO();
		try {
			dao.displaySubjectwiseTitles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
