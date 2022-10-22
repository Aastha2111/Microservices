package org.ncu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.com.Course;
import org.ncu.com.Instructor;
import org.ncu.com.InstructorDetail;

public class CourseDao {
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void create() {
		
		Course c1 = new Course("Java", 40);
		Course c2 = new Course("Python", 30);
		
		Instructor ins = new Instructor("prashant", "sharma", "prashant@ncuindia.edu");
		
		c1.setInstructor(ins);
		c2.setInstructor(ins);
		
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		
		session.save(c1);
		session.save(c2);
		
		session.getTransaction().commit();
	
		session.close();
		System.out.println("Data saved succcessfully!!");
	}
}