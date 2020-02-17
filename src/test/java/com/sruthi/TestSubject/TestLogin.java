package com.sruthi.TestSubject;

import com.sruthi.UserService;
import com.sruthi.model.Users;

public class TestLogin {

	public static void main(String[] args) {

		Users user = new Users();
		user.setUserName("Sruthi");
		user.setSetPassword("sru12");
		UserService.login(user);
	}

}
