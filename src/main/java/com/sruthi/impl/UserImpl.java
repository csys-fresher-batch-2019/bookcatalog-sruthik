package com.sruthi.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.UserDAO;
import com.sruthi.model.Publisher;
import com.sruthi.model.Users;

public class UserImpl implements UserDAO {
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public List<Users> displayUsers() throws Exception {
		List<Users> list = new ArrayList<>();
		String sql = "Select * from Users";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
	    Statement stmt=connection.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	String userName = rs.getString("user_name");
	    	String userMail = rs.getString("user_mail_id");
	    	String password = rs.getString("set_password");
	    	String cpassword = rs.getString("confirm_password");
	    	long phNo = rs.getLong("ph_no");
	    	Users user = new Users();
	    	user.setUserName(userName);
	    	user.setUserMailId(userMail);
	    	user.setSetPassword(password);
	    	user.setConfirmPassword(cpassword);
	    	user.setPhNo(phNo);
	    	
	    	list.add(user);
	    	
	    }
		return list;
	}

	@Override
	public void addUser(Users user) throws Exception {
		// TODO Auto-generated method stub
//			Connection con=ConnectionUtil.getConnection();
//			CallableStatement stmt=con.prepareCall("{call password_procedure(?,?,?)}");
//			stmt.setString(1, user.getSetPassword());
//			stmt.setString(2, user.getConfirmPassword());
//			stmt.registerOutParameter(3, Types.VARCHAR);
//			stmt.executeUpdate();
//			String status=stmt.getString(3);
//			if(status.equals("success")) {
			
			String sql = "insert into Users(user_name,user_mail_id,set_password,confirm_password,ph_no)values(?,?,?,?,?)";
			
			//step 1:Get the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
			//step 2:Prepare the query
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserMailId());
			pst.setString(3, user.getSetPassword());
			pst.setString(4, user.getConfirmPassword());
			pst.setLong(5, user.getPhNo());
			
			
			//step 3:Execute the query
			int rows = pst.executeUpdate();
			LOGGER.info("No of rows inserted:"+rows);
		}
			
		
		
	}
	


