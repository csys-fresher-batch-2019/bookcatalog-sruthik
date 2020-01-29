package com.sruthi.Title;


import java.util.List;

public interface TitleDAO {
	void addTitle(Title title) throws Exception;
	void ChangePubDate(Title title) throws Exception;
	List<Title> displayTitleWithPrice() throws Exception;
	void deleteTitle(int titleId) throws Exception;
	
	
}
