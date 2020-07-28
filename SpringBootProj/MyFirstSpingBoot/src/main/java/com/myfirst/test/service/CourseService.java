package com.myfirst.test.service;

import java.util.List;

import com.myfirst.test.model.Course;

public interface CourseService {
	public List<Course> getAllCourses();
	public void submitCourse(Course course);
	public void deleteCourse(Course course);
	public void updateCourse(Course course);

}
