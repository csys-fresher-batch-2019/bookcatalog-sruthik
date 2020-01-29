package com.sruthi.TestPublisher;

import java.io.IOException;

import com.sruthi.FileUtil;

public class TestWrite {

	public static void main(String[] args) throws IOException{
		FileUtil.writeToFile("publishers.txt","sureka,sureka@gmail.com,7658938769\nvidhya,vidhya@gmail.com,9042768769");
		
		

	}

}
