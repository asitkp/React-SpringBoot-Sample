package com.myfirst.test.DAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myfirst.test.model.Student;

public interface StudentDAO {
	public List<Student> getStudents();

}
