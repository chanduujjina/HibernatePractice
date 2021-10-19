package com.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.demo.entity.Employee;
import com.hibernate.demo.util.HibernateUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	saveEmployee(new Employee("divya", "female"));
    }
    
   public static void  saveEmployee(Employee emp){
	   SessionFactory factory = HibernateUtility.getSessionFactory();
	   
	   Session session =factory.openSession();
	   
	  Transaction  transaction =session.beginTransaction();
	   
	   session.save(emp);
	   transaction.commit();
	   session.close();
	   System.out.println(emp);
    }
}
