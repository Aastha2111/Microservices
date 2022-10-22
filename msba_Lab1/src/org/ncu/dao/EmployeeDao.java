package org.ncu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.com.Employee;

public class EmployeeDao {
	
	
  SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

  //Primary key Experiment
 public void create() {
	  
//	  Employee emp = new Employee("identitysrategy"," Delhi", 1000000, "identity@xyz.com");
//	  Employee emp = new Employee("identitysrt_1"," gururgram", 2000000, "identitysrt1@xyz.com");
//	 Employee emp = new Employee("identitysrt_2","uttarPradesh", 2000000, "identitysrt2@xyz.com");
//	 Employee emp = new Employee("tablestrategy","Kerala", 90000000, "tablestr1@xyz.com");
//	 Employee emp = new Employee("tablestrategy2","Kerala", 90000000, "tablesty2@xyz.com");
//	 Employee emp = new Employee("tablestrategy3","Kerala", 90000000, "tablesty3@xyz.com");
	 Employee emp = new Employee("tablestrategy4","Kerala", 90000000, "tablesty4@xyz.com");
	  

	//step 1: create a new session or open an existing session
		Session session = sessionFactory.openSession();
	
		// step 2: create a transaction boundary
		session.beginTransaction();
		
		// step 3: perform save/insert operation
		session.save(emp);
		
		// step 4: commit the transaction
		session.getTransaction().commit();
		
		// step 5: close the session
//		session.close();
		System.out.println("Data saved succcessfully!!");
  }
  
  
  
  
  
//  saving object state into the database
//  public void create() {
//	  
//	  Employee emp = new Employee(003,"aastha"," Delhi", 1000000, "aastha@xyz.com");
//
//	//step 1: create a new session or open an existing session
//		Session session = sessionFactory.openSession();
//	
//		// step 2: create a transaction boundary
//		session.beginTransaction();
//		
//		// step 3: perform save/insert operation
//		session.save(emp);
//		
//		// step 4: commit the transaction
//		session.getTransaction().commit();
//		
//		// step 5: close the session
////		session.close();
//		System.out.println("Data saved succcessfully!!");
//  }
  
 
public void read() {
	  
	//step 1: create a new session or open an existing session
	  Session session = sessionFactory.openSession();
	// step 2: create a transaction boundary
	  session.beginTransaction();
		// step 3: perform save/insert operation
	  // we pass Entity in SessionQuery and use getResult List
      List<Employee> employeeList = (List) session.createQuery("from Employee").getResultList();
//      Query query = session.createQuery("from emp_table");
      
      if(employeeList == null) {
    	  System.out.println("No Employee Exist");
      }    
      System.out.println("*** Employee Details ***");   
      for(Employee e : employeeList)
      {
          System.out.println("Employee ID   : "+ e.getEmpNo());
          System.out.println("Employee Name : "+ e.getEmpName());
          System.out.println("Employee Email  : "+ e.getEmail());
          System.out.println("Employee Address  : "+ e.getAddress());
          System.out.println("Employee Salary  : "+ e.getSalary());   
      }
   // step 4: commit the transaction
      session.getTransaction().commit();
	  
   // step 5: close the session
   		session.close();
   		System.out.println("Data Read succcessfully!!");
	  
	  
	  
  }
  
  public void update(int empNo,String name) {
	//step 1: create a new session or open an existing session
	  Session session = sessionFactory.openSession();
	// step 2: create a transaction boundary
		  session.beginTransaction();
		// step 3: perform save/insert operation
		  Employee empl = (Employee)session.get(Employee.class,empNo);
		  empl.setEmpName(name);
		  session.update(empl);
		  
		  // step 4: commit the transaction
	      session.getTransaction().commit();
		  
	   // step 5: close the session
	   		session.close();
	   		System.out.println("Data updated succcessfully!!");
		  
	  
  }
  
  public void delete(int empNo) {
	//step 1: create a new session or open an existing session
	  Session session = sessionFactory.openSession();
	// step 2: create a transaction boundary
	  session.beginTransaction();
	// step 3: perform save/insert operation
	  Employee employee = (Employee)session.get(Employee.class, empNo);
      
      session.delete(employee);
      
	  // step 4: commit the transaction
      session.getTransaction().commit();
	  
   // step 5: close the session
   		session.close();
   		System.out.println("Data delete succcessfully!!");
  }

}
