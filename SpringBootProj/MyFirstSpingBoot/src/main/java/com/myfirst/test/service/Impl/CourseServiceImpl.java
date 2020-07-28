package com.myfirst.test.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.myfirst.test.mapper.courseMapper;
import com.myfirst.test.mapper.studentMapper;
import com.myfirst.test.model.Course;
import com.myfirst.test.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public List<Course> getAllCourses() {
		System.out.println("Inside Service class...");
		String sqlqry="SELECT * FROM course";
		
		
		 return  jdbctemplate.query(sqlqry,new courseMapper());
		
		
		
	}

	@Override
	public void submitCourse(Course course) {
		String sqlqry="insert into  course values (?,?,?)";
		
		
		 jdbctemplate.update(sqlqry,course.getCourseid(),course.getCoursetitle(),course.getCoursedesc());
		
	}

	@Override
	public void deleteCourse(Course course) {
		System.out.println("Here in delete course..."+course.getCourseid());
		String sqlqry="delete from  course where courseid=?";
		
		try {
		 jdbctemplate.update(sqlqry,course.getCourseid());
		}catch(Exception ex) {ex.printStackTrace();}
		
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
String sqlqry="update  course set title=?,description=? where courseid=?";
		
		try {
		 jdbctemplate.update(sqlqry,course.getCoursetitle(),course.getCoursedesc(),course.getCourseid());
		}catch(Exception ex) {ex.printStackTrace();}
		
	}

}
