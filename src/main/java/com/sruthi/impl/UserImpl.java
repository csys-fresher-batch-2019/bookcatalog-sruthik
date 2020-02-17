package com.sruthi.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sruthi.ConnectionUtil;
import com.sruthi.Logger;
import com.sruthi.dao.UserDAO;
import com.sruthi.model.Users;

public class UserImpl implements UserDAO {
	private static final Logger LOGGER = Logger.getInstance();
	@Override
	public List<Users> displayUsers() {
		List<Users> list = new ArrayList<>();
		String sql = "Select * from Users";
		
	    try (Connection connection = ConnectionUtil.getConnection();
	    Statement stmt=connection.createStatement();ResultSet rs = stmt.executeQuery(sql)){
			
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
				LOGGER.debug(userName+" "+userMail+" "+password+" "+cpassword);
				list.add(user);
				
			}
		} catch (Exception e) {
			
			LOGGER.debug(e);
		}
		return list;
	}

	@Override
	public void addUser(Users user) {
			
			String sql = "insert into Users(user_name,user_mail_id,set_password,confirm_password,ph_no)values(?,?,?,?,?)";
			
			try(Connection connection =ConnectionUtil.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql)) {
				pst.setString(1, user.getUserName());
				pst.setString(2, user.getUserMailId());
				pst.setString(3, user.getSetPassword());
				pst.setString(4, user.getConfirmPassword());
				pst.setLong(5, user.getPhNo());
				
				int rows = pst.executeUpdate();
				LOGGER.info("No of rows inserted:"+rows);
			} catch (Exception e) {
				e.printStackTrace();
				
				LOGGER.debug(e);
			}
		}

	}
	


