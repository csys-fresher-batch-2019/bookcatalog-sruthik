package com.sruthi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.sruthi.model.Users;

public class UserService {
	private static final Logger LOGGER = Logger.getInstance();
	private UserService () {
	    throw new IllegalStateException("Utility class");
	  }
	public static boolean login(Users user) {
		try(Connection con = ConnectionUtil.getConnection();CallableStatement stmt=con.prepareCall("{call login_procedure(?,?,?)}")) {
			stmt.setString(1,user.getUserName());
			stmt.setString(2, user.getSetPassword());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
			String status=stmt.getString(3);
			if(status.equals("Login successful")) {
			
			LOGGER.debug("Logged In");
			return true;
}
			else {
				LOGGER.debug("Logged out");
				return false;
			}
		} catch (Exception e) {
			
			
			LOGGER.error(e);
			
		}
		return false;
	
	}
}
