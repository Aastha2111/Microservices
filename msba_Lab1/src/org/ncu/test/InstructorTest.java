package org.ncu.test;

import org.ncu.com.*;
import org.ncu.dao.CourseDao;
import org.ncu.dao.InstructorDao;
//Lab Experiment
//prashant Sharma 19csu003


public class InstructorTest {

	public static void main(String[] args) {
//		 InstructorDetail insDao = new InstructorDetail(); 
		InstructorDao insDao = new InstructorDao(); 
//		 CourseDao dao = new CourseDao(); 
		insDao.create();
	}
}