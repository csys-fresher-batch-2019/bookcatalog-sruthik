package com.sruthi.TestPublisher;

import java.util.List;

import com.sruthi.Publisher.Publisher;
import com.sruthi.Publisher.PublisherImpl;

public class TestExportData {

	public static void main(String[] args) throws Exception {
		PublisherImpl daoImpl = new PublisherImpl();
		List<Publisher> list= daoImpl.displayPubId();
		String fileContent = "";
		for(Publisher pub:list) {
			String line = pub.getPubName()+","+pub.getPubMailId()+","+pub.getPubPhNo();
			fileContent = fileContent+line+"\n";
	
		}
		System.out.println(fileContent);
		
		
	}

}
