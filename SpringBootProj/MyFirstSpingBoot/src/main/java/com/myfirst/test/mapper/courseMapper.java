package com.myfirst.test.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myfirst.test.model.Course;
import com.myfirst.test.model.Student;

public class courseMapper implements RowMapper<Course>{

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Course course=new Course();
		course.setCourseid(rs.getString(1));
		course.setCoursetitle(rs.getString(2));
		course.setCoursedesc(rs.getString(3));
		return course;
	}

}
