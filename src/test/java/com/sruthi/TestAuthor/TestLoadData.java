package com.sruthi.TestAuthor;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.sruthi.Author.Author;
import com.sruthi.Author.AuthorImpl;

public class TestLoadData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "authors.txt";
		Path path = Paths.get(fileName);
		List<String> lines = Files.readAllLines(path);
		for(String line:lines) {
			System.out.println(line);
			String[] row = line.split(",");
			
			String authorName = row[0];
			String authorMailId = row[1];
			String authorPhNo = row[2];
			Author author = new Author();
			
			author.setAuthorName(authorName);
			author.setAuthorMailId(authorMailId);
			author.setAuthorPhNo(authorPhNo);
			System.out.println(author);
			AuthorImpl daoImpl = new AuthorImpl();
		       daoImpl.addAuthor(author);
		       
		}
		

	}

}
