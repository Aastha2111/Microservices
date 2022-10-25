package org.com.ncu.RestfulServicesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.com.ncu.RestfulServicesModel.Student;

public class StudentService {

 static HashMap<Integer,Student> studentIdMap=getStudentIdMap();


 public StudentService() {
  super();

  if(studentIdMap==null)
  {
	  studentIdMap=new HashMap<Integer,Student>();
  // Creating some objects of Country while initializing
   Student firstStudent=new Student(1, "aastha 1",123);
   Student secondStudent=new Student(2, "student 2",214);
   Student threeStudent=new Student(3, "student 3",600);
   Student fourStudent=new Student(4, "student 4",700);


   studentIdMap.put(1,firstStudent);
   studentIdMap.put(2,secondStudent);
   studentIdMap.put(3,threeStudent);
   studentIdMap.put(4,fourStudent);
  }
 }

 public List<Student> getAllStudents()
 {
  List<Student> students = new ArrayList<Student>(studentIdMap.values());
  return students;
 }

 public Student getStudent(int id)
 {
  Student student= studentIdMap.get(id);
  return student;
 }
 public Student addStudent(Student student)
 {
  student.setId(getMaxId()+1);
  studentIdMap.put(student.getId(), student);
  return student;
 }
 
 public Student updateStudent(Student student)
 {
  if(student.getId()<=0)
   return null;
  studentIdMap.put(student.getId(), student);
  return student;

 }
 public void deleteStudent(int id)
 {
	 studentIdMap.remove(id);
 }

 public static HashMap<Integer, Student> getStudentIdMap() {
  return studentIdMap;
 }
 

 // Utility method to get max id
 public static int getMaxId()
 {   int max=0;
 for (int id:studentIdMap.keySet()) {  
  if(max<=id)
   max=id;

 }  
 return max;
 }
}

