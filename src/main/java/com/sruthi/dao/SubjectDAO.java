package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Subject;

public interface SubjectDAO {
	void addSubject(Subject sub) ;
	List<Subject> displaySubjectwiseTitles() ;
	void deleteSubject(int subId) ;
	void updateSubject(Subject sub) ;
	
}
