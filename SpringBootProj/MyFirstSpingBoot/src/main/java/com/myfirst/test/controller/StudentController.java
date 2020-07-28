package com.myfirst.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfirst.test.DAO.StudentDAO;
import com.myfirst.test.model.Student;

@RestController

public class StudentController {
	
	Logger logger=LoggerFactory.getLogger(FirstControllers.class); 
	
	@Autowired
	StudentDAO stddao;
	
	@GetMapping(value = "/getStudents",produces = "application/json")
	public List<Student> getStudents()
	{
		logger.info("method called..");
		return stddao.getStudents();
	}

}
