package com.myfirst.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myfirst.test.DAO.CourseDAO;
import com.myfirst.test.model.Course;
import com.myfirst.test.service.Impl.StudentServiceImpl;

@RestController
@CrossOrigin
public class CourseController {
	
	@Autowired
	CourseDAO coursedao;
	
	Logger logger=LoggerFactory.getLogger(CourseController.class); 
	
	@GetMapping("/getallcourses")
	 @CrossOrigin(origins = "http://localhost:3000")
	public List<Course> getAllCourses(){
		return coursedao.getAllCourse();
		
	}
	
	
	@PostMapping(path="/addcourse",consumes = "application/json",produces = "application/json")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	public String addCourse(@RequestBody Course course,HttpServletResponse res){
		logger.info("course object received:"+course.getCoursetitle()+" "+course.getCourseid());
		String msg="";
		try {
			coursedao.submitCourse(course);
			//res.set
			 msg="Successfully added";
			res.setStatus(200);
		}catch(Exception ex) {
			msg="Exception occour. Please contact admin";
			res.setStatus(400);
		}
		return new String(msg);
	}
	
	@PostMapping(path="/deletecourse",consumes = "application/json")
	 @CrossOrigin(origins = "http://localhost:3000")
	public String deleteCourse(@RequestBody Course course,HttpServletResponse res){
		logger.info("course object received at delete..:"+course.getCourseid());
		String msg="";
		try {
			coursedao.deleteCourse(course);
			 msg="Successfully deleted";
			res.setStatus(200);
		}catch(Exception ex) {
			msg="Exception occour. Please contact admin";
			res.setStatus(400);
		}
		return msg;
	}
	
	@PostMapping(path="/updatecourse",consumes = "application/json")
	 @CrossOrigin(origins = "http://localhost:3000")
	public String updateCourse(@RequestBody Course course,HttpServletResponse res){
		logger.info("course object received at update..:"+course.getCourseid());
		String msg="";
		try {
			coursedao.updateCourse(course);
			 msg="Successfully Updated couurse-"+course.getCourseid();
			res.setStatus(200);
		}catch(Exception ex) {
			msg="Exception occour. Please contact admin";
			res.setStatus(400);
		}
		return msg;
	}

}
