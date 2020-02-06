package com.sruthi.model;



public class Subject {
private int subId;
private String subName;
public int getSubId() {
	return subId;
}
public void setSubId(int subId) {
	this.subId = subId;
}
public String getSubName() {
	return subName;
}
public String setSubName(String subName) {
	return this.subName = subName;
}
@Override
public String toString() {
	return "Subject [subId=" + subId + ", subName=" + subName + "]";
}



}
