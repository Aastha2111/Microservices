package org.ncu.test;
//Lab2 :29/08/22

//19csu003-aaastha
//Primary Key Strategy Generation

import org.ncu.dao.EmployeeDao;

public class EmployeeTest {
	public static void main(String args[]) {
		EmployeeDao empdao = new EmployeeDao();
		empdao.create();
	
	}

}



//empdao.update(3,"MAdaan");
//empdao.read();
//empdao.delete(3);

