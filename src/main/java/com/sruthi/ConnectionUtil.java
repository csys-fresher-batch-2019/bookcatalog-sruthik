package com.sruthi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private ConnectionUtil() {
	    throw new IllegalStateException("Utility class");
	  }
	public static Connection getConnection() throws  SQLException {
		
		String server = "CSLH2023";
		String username = "system";
		String password = "oracle";
	    
		return DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:XE",username,password);
	}
}
