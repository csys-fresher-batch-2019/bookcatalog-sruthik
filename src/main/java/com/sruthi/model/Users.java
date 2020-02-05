package com.sruthi.model;

public class Users {
     private String userName;
     private String userMailId;
     private String setPassword;
     private String confirmPassword;
     private long phNo;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getSetPassword() {
		return setPassword;
	}
	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", userMailId=" + userMailId + ", setPassword=" + setPassword
				+ ", confirmPassword=" + confirmPassword + ", phNo=" + phNo + "]";
	}
     
	
	
}
