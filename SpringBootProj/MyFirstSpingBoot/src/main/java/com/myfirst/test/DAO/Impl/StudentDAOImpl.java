package com.myfirst.test.DAO.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myfirst.test.DAO.StudentDAO;
import com.myfirst.test.model.Student;
import com.myfirst.test.service.StudentService;


@Component
public class StudentDAOImpl implements StudentDAO{
	
	Logger logger=LoggerFactory.getLogger(StudentDAOImpl.class); 
	
	@Autowired
	StudentService stserv;

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		logger.info("Student DAO Impl called...");
		return stserv.getAllStudents();
	}

}
