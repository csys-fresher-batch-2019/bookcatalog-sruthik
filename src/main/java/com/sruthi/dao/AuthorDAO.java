package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Author;

public interface AuthorDAO {
	void addAuthor(Author author) throws Exception;
	List<Author> displayNumberOfAuthors() throws Exception;
	void updateAuthor(Author author) throws Exception;
	void deleteAuthor(int authorId) throws Exception;
	
}
