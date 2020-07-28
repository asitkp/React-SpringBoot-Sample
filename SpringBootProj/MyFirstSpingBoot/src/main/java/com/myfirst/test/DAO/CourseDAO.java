package com.myfirst.test.DAO;

import java.util.List;

import com.myfirst.test.model.Course;

public interface CourseDAO {
	public List<Course> getAllCourse();
	public void submitCourse(Course course);
	public void deleteCourse(Course course);
	public void updateCourse(Course course);

}
