package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Author;

public interface AuthorDAO {
	void addAuthor(Author author);
	List<Author> displayNumberOfAuthors();
	void updateAuthor(Author author);
	void deleteAuthor(int authorId) ;
	
}
