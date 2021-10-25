package com.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.demo.entity.Account;
import com.hibernate.demo.entity.Address;
import com.hibernate.demo.entity.Customer;
import com.hibernate.demo.util.HibernateUtility;

public class UnieMapping {

	public static void main(String[] args) {
		
		
		Customer customer = new Customer();
		
		Address address = new Address();
		address.setHno("LIG-233");
		address.setCity("Hyd");
		customer.setAddress(address);
		
		List<Account> accountList = new ArrayList();
		
		Account acc1 = new Account();
		acc1.setAccount_name("ANdhrabank");
		acc1.setAccountType("savings");
		
		Account acc2 = new Account();
		acc2.setAccount_name("SBI");
		acc2.setAccountType("current");
		
		accountList.add(acc1);
		accountList.add(acc2);
		customer.setAccountList(accountList);
		customer.setCustomerName("Divya");
		customer.setGender("female");
		
		saveCustomer(customer);
		
	}
	
	public static void saveCustomer(Customer customer) {

		Session session = HibernateUtility.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
		System.out.println(customer);
	}

}
