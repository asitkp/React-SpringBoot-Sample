package com.myfirst.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstControllers {
	
	@Value("${custom.value}")
	private String customVal;
	
	Logger logger=LoggerFactory.getLogger(FirstControllers.class); 
	
	@GetMapping(value = "/sayHello",produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayHello()
	{
		logger.info("Hello controller called..info");
		logger.trace("Hello controller called..");
		logger.error("Error occour....");
		return "Hello "+customVal;
	}

}
