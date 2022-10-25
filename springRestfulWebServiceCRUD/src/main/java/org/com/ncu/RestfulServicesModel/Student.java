package org.com.ncu.RestfulServicesModel;

//simple REstful web service 
//Lab Experiment
//aastha-19csu003
public class Student{
	
	int id;
	String studentName;	
	int marks;
	
	public Student() {
		super();
		
	}
	
	public Student(int id, String studentName, int marks) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
}