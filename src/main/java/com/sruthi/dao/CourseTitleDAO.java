package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.CourseTitles;

public interface CourseTitleDAO {
    void addCourseTitle(CourseTitles course);
    void deleteCourseTitle(int courseId) ;
    void updateCourseTitle(CourseTitles course);
    List<CourseTitles> displayCourseTitles() ;
}
