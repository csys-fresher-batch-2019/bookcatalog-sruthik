package com.sruthi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.sruthi.model.Users;

public class UserService {
	public static boolean login(Users user) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		CallableStatement stmt=con.prepareCall("{call login_procedure(?,?,?)}");
		stmt.setString(1,user.getUserName());
		stmt.setString(2, user.getSetPassword());
		stmt.registerOutParameter(3, Types.VARCHAR);
		stmt.executeUpdate();
		String status=stmt.getString(3);
		if(status.equals("Login successful")) {
		
		System.out.println("Logged In");
		return true;
	}
		else {
			System.out.println("Logged out");
			return false;
		}
	
	}
}
