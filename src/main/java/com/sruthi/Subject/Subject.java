package com.sruthi.Subject;

public class Subject {
private int subId;
private CheckSubjectEnum subName;
public int getSubId() {
	return subId;
}
public void setSubId(int subId) {
	this.subId = subId;
}
public CheckSubjectEnum getSubName() {
	return subName;
}
public void setSubName(CheckSubjectEnum subName) {
	this.subName = subName;
}
@Override
public String toString() {
	return "Subject [subId=" + subId + ", subName=" + subName + "]";
}



}
