package com.sruthi.dao;

import java.util.List;

import com.sruthi.model.CourseTitles;

public interface CourseTitleDAO {
    void addCourseTitle(CourseTitles course) throws Exception;
    void deleteCourseTitle(int courseId) throws Exception;
    void updateCourseTitle(CourseTitles course) throws Exception;
    List<CourseTitles> displayCourseTitles() throws Exception;
}
