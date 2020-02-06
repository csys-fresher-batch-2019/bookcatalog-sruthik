package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.Publisher;
import com.sruthi.model.Users;

public interface UserDAO {
	List<Users> displayUsers() ;
	void addUser(Users user) ;

}
