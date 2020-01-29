package com.sruthi.Subject;

import java.util.List;

public interface SubjectDAO {
	void addSubject(Subject sub) throws Exception;
	List<Subject> displaySubjectwiseTitles() throws Exception;
	void deleteSubject(int subId) throws Exception;
	void updateSubject(Subject sub) throws Exception;
	
}
