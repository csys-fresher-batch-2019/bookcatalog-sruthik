package com.sruthi.TestAuthor;


//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.List;

import com.sruthi.Author.Author;
import com.sruthi.Author.AuthorImpl;

public class TestExportData {

	public static void main(String[] args) throws Exception{
		AuthorImpl a = new AuthorImpl();
		List<Author> list = a.displayNumberOfAuthors();
		String fileContent = "";
		for(Author author:list) {
			String line = author.getAuthorName()+","+author.getAuthorMailId()+","+author.getAuthorPhNo();
			fileContent = fileContent+line+"\n";
	
		}
		System.out.println(fileContent);
		//Path path = Paths.get("authors.txt");
		
		

	}

}
