package com.sruthi.dao;


import java.time.LocalDate;
import java.util.List;

import com.sruthi.model.Title;

public interface TitleDAO {
	void addTitle(Title title) ;
	void changePubDate(Title title) ;
	List<Title> displayTitleWithPrice() ;
	void deleteTitle(int titleId) ;
	List<Title> displayTitleForCourseId(int courseId) ;
	List<Title> displayYearWiseBooks(LocalDate pubDate) ;
	List<Title> displayBooksPublishedByIndividualPublishers();
	List<Title> displayByRecentBooks() ;
}
