package com.sruthi.TestPublisher;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.sruthi.Publisher.Publisher;
import com.sruthi.Publisher.PublisherImpl;

public class TestLoadData {

	public static void main(String[] args) throws Exception {
		String fileName = "publishers.txt";
		Path path = Paths.get(fileName);
		List<String> lines = Files.readAllLines(path);
		for(String line:lines) {
			System.out.println(line);
			String[] row = line.split(",");
			String pubName = row[0];
			String pubMailId = row[1];
			String pubPhNo = row[2];
			Publisher pub = new Publisher();
			pub.setPubName(pubName);
			pub.setPubMailId(pubMailId);
			pub.setPubPhNo(pubPhNo);
			
			PublisherImpl daoImpl = new PublisherImpl();
			daoImpl.addPublisher(pub);
		}
			
	}

}
