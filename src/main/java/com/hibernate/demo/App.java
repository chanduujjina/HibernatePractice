package com.hibernate.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.hibernate.demo.entity.Employee;
import com.hibernate.demo.util.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//saveEmployee(new Employee("divya", "female"));
		// Employee emp = findEmployeeById(2);
		// System.out.println(emp);
		// updateEmployeeById(new Employee("gouse patan", "male"),2);
		// deleteEmployeeById(3);

		// List<Employee> employeeList = getAllEmployees();
		// System.out.println(employeeList);
		List<Employee> employeeList = findEmployeeByAttribute_v3(Arrays.asList("chandu","divya"));
		System.out.println(employeeList);
	}

	public static void saveEmployee(Employee emp) {

		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
		session.close();
		System.out.println(emp);
	}

	public static void updateEmployeeById(Employee emp, int empId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, empId);

		employee.setName(emp.getName());
		employee.setGender(emp.getGender());
		session.saveOrUpdate(employee);
		transaction.commit();
		session.close();
	}

	public static void deleteEmployeeById(int empId) {
		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, empId);
		session.delete(employee);
		transaction.commit();
		session.close();
	}

	public static List<Employee> getAllEmployees() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery("from Employee");
		List<Employee> employeeList = query.list();
		return employeeList;
	}

	public static List<Employee> findEmployeeByAttribute(String name, String gender,int id) {
		Session session = HibernateUtility.getSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("name", name));
		crit.add(Restrictions.eq("gender", gender));
		crit.add(Restrictions.ge("id", id));
		List<Employee> employeeList = crit.list();
		return employeeList;
	}

	public static List<Employee> findEmployeeByAttribute_v1(String name, String gender) {
		Session session = HibernateUtility.getSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.or(Restrictions.eq("name", name), Restrictions.eq("gender", gender)));
		List<Employee> employeeList = crit.list();
		return employeeList;
	}
	
	public static List<Employee> findEmployeeByAttribute_v2(String name) {
		Session session = HibernateUtility.getSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.like("name", name, MatchMode.START));
		List<Employee> employeeList = crit.list();
		return employeeList;
	}
	
	public static List<Employee> findEmployeeByAttribute_v3(List<String> nameList) {
		Session session = HibernateUtility.getSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.in("name", nameList));
		List<Employee> employeeList = crit.list();
		return employeeList;
	}

	public static Employee findEmployeeById(int empId) {
		Session session = HibernateUtility.getSession();
		Employee emp = (Employee) session.load(Employee.class, empId);
		return emp;
	}

	public static Employee findEmployeeById_v1(int empId) {
		Session session = HibernateUtility.getSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		return emp;
	}
}
