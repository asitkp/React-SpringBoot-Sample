package com.myfirst.test.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.myfirst.test.mapper.studentMapper;
import com.myfirst.test.model.Student;
import com.myfirst.test.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	Logger logger=LoggerFactory.getLogger(StudentServiceImpl.class); 
	
	@Autowired
	JdbcTemplate jdbctemp;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		logger.info("Student service implementation called...");
		String query="select * from students";
		
		 return  jdbctemp.query(query,new studentMapper());
	}

}
