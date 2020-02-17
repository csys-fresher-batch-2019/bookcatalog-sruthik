package com.sruthi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ConnectionUtil {
	private ConnectionUtil() {
	    throw new IllegalStateException("Utility class");
	  }
	public static Connection getConnection() throws  SQLException {
		
		String server = "localhost";
		String username = "system";
		String password = "oracle";
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:oracle:thin:@"+server+":1521:XE",username,password);
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
	public static Jdbi getJdbi() {
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Jdbi jdbi = Jdbi.create(connection);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}
}
