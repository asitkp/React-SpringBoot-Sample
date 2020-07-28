package com.myfirst.test.DAO.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myfirst.test.DAO.CourseDAO;
import com.myfirst.test.controller.FirstControllers;
import com.myfirst.test.model.Course;
import com.myfirst.test.service.CourseService;

@Component
public class CourseDAOImpl implements CourseDAO {

	Logger logger=LoggerFactory.getLogger(FirstControllers.class); 
	
	@Autowired
	CourseService cservice;
	
	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		logger.info("Here in getAllCourse...Impl");
		return cservice.getAllCourses();
	}

	@Override
	public void submitCourse(Course course) {
		// TODO Auto-generated method stub
		cservice.submitCourse(course);
	}

	@Override
	public void deleteCourse(Course course) {
		System.out.println("Here in delete DAOImpl...");
		cservice.deleteCourse(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		cservice.updateCourse(course);
	}

}
