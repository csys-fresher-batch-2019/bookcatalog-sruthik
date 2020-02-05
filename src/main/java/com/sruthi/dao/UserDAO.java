package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Publisher;
import com.sruthi.model.Users;

public interface UserDAO {
	List<Users> displayUsers() throws Exception;
	void addUser(Users user) throws Exception;

}
