package org.ncu.com;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Generated;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




///Lab2 :29/08/22
//19csu003-aastha
//Primary Key Generations strategy

@Entity
@Table(name="Emp_PrimaryKeyGeneration")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_no")
	private int empNo;
	@Column(name="emp_name", length = 30, nullable = false, unique = true )
	private String empName;
	@Column(name="address", length = 50)
	private String address;
	@Column(name="salary")
	private int salary;
	@Column(name="email", length = 50)
	private String email;
	
	
	
	//help while Eager Loading 
	public Employee() {
		super();
	}

	public Employee( String empName, String address, int salary, String email) {
		super();
		this.empName = empName;
		this.address = address;
		this.salary = salary;
		this.email = email;
	}


	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ ", email=" + email + "]";
	}

}






//Lab2 :29/08/22
//19csu003-aastha
//crud operation in hibernate

//@Entity
//@Table(name="emp_table")
//public class Employee {
//	
//	@Id
//	@Column(name = "emp_no")
//	private int empNo;
//	@Column(name="emp_name", length = 30, nullable = false, unique = true )
//	private String empName;
//	@Column(name="address", length = 50)
//	private String address;
//	@Column(name="salary")
//	private int salary;
//	@Column(name="email", length = 20)
//	private String email;
//	
//	
//	
//	//help while Eager Loading 
//	public Employee() {
//		super();
//	}
//
//
//
//	public Employee(int empNo, String empName, String address, int salary, String email) {
//		super();
//		this.empNo = empNo;
//		this.empName = empName;
//		this.address = address;
//		this.salary = salary;
//		this.email = email;
//	}
//
//
//	
//	public int getEmpNo() {
//		return empNo;
//	}
//	public void setEmpNo(int empNo) {
//		this.empNo = empNo;
//	}
//	public String getEmpName() {
//		return empName;
//	}
//	public void setEmpName(String empName) {
//		this.empName = empName;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public int getSalary() {
//		return salary;
//	}
//	public void setSalary(int salary) {
//		this.salary = salary;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	@Override
//	public String toString() {
//		return "Employee [empNo=" + empNo + ", empName=" + empName + ", address=" + address + ", salary=" + salary
//				+ ", email=" + email + "]";
//	}
//
//}