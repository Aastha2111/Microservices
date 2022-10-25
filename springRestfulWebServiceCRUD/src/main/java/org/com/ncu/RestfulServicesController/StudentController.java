package org.com.ncu.RestfulServicesController;

import java.util.List;

import org.com.ncu.RestfulServicesModel.Student;
import org.com.ncu.RestfulServicesService.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//aastha-19csu003
@RestController
public class StudentController {

	StudentService studentService = new StudentService();

	@RequestMapping(value = "/students", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Student> getStudents() {
		List<Student> listOfStudents = studentService.getAllStudents();
		return listOfStudents;
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST, headers = "Accept=application/json")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@RequestMapping(value = "/students", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);

	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);

	}	
}
