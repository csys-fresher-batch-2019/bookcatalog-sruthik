package com.sruthi.TestSubject;

import java.io.IOException;

import com.sruthi.FileUtil;

public class TestWrite {

	public static void main(String[] args) throws IOException{
		FileUtil.writeToFile("subjects.txt", "Tamil");
		
	}

}
