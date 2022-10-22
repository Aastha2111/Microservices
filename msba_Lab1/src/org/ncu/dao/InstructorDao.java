package org.ncu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.com.Course;
import org.ncu.com.Instructor;
import org.ncu.com.InstructorDetail;

//hibernate Mapping Lab Experiment
//aastha-19csu0003

public class InstructorDao {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void create() {
		
		Instructor ins = new Instructor("Nick", "Jonas", "nickjn@ncu.edu");
		
		InstructorDetail ins_detail = new InstructorDetail("www.jonasnick.com", "New York");
		
		ins.setInstructorDetail(ins_detail);
		
		Course c1 = new Course("XYZ", 10);
		
		List<Course> course = new ArrayList<Course>();
		course.add(new Course("Big Data", 35));
		course.add(new Course("French", 50));
		course.add(new Course("ITP", 45));
		
		ins.setCourses(course);
		
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		
		session.save(ins);
		
		session.getTransaction().commit();
		
		session.close();
		System.out.println("Data saved succcessfully!!");
	}
	
	


}