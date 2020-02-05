package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Subject;

public interface SubjectDAO {
	void addSubject(Subject sub) throws Exception;
	List<Subject> displaySubjectwiseTitles() throws Exception;
	void deleteSubject(int subId) throws Exception;
	void updateSubject(Subject sub) throws Exception;
	
}
