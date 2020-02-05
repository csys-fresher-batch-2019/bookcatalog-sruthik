package com.sruthi.model;

public class CourseTitles {
 private int courseId;
 private int titleId;
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
public int getTitleId() {
	return titleId;
}
public void setTitleId(int titleId) {
	this.titleId = titleId;
}
@Override
public String toString() {
	return "com.sruthi.courseTitles [courseId=" + courseId + ", titleId=" + titleId + "]";
}

}
