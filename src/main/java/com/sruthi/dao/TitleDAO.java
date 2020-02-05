package com.sruthi.dao;


import java.time.LocalDate;
import java.util.List;

import com.sruthi.model.Title;

public interface TitleDAO {
	void addTitle(Title title) throws Exception;
	void ChangePubDate(Title title) throws Exception;
	List<Title> displayTitleWithPrice() throws Exception;
	void deleteTitle(int titleId) throws Exception;
	List<Title> displayTitleForCourseId(int courseId) throws Exception;
	List<Title> displayYearWiseBooks(LocalDate pubDate) throws Exception;
	List<Title> displayBooksPublishedByIndividualPublishers()throws Exception;
	List<Title> displayByRecentBooks() throws Exception;
}
