package com.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.demo.entity.Employee;
import com.hibernate.demo.util.HibernateUtility;

public class Demo1 {

	public static void main(String[] args) {
		
		String name = "test";
		String gender = "male";
		List<Employee> employeeList = new ArrayList();
		for(int i=1;i<=1000;i++) {
			Employee emp = new Employee();
			emp.setName(name+i);
			gender = i%2==0 ? "male": "female";
			emp.setGender(gender);
			employeeList.add(emp);
		}
		saveEmployee(employeeList);

	}
	
	public static void saveEmployee(List<Employee> employeeList) {

		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		for(Employee employee :employeeList) {
			session.save(employee);
		}
		transaction.commit();
		session.close();
		//System.out.println(employeeList);
	}

}
