package com.sruthi.Author;

import java.util.List;

public interface AuthorDAO {
	void addAuthor(Author author) throws Exception;
	List<Author> displayNumberOfAuthors() throws Exception;
	void updateAuthor(Author author) throws Exception;
	void deleteAuthor(int authorId) throws Exception;
	
}
