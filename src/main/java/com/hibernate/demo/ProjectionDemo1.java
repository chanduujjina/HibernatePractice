package com.hibernate.demo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.hibernate.demo.entity.Employee;
import com.hibernate.demo.util.HibernateUtility;

public class ProjectionDemo1 {
public static void main(String[] args) {
	List<Integer> list =getAllId();
	System.out.println(list);
	
	List list1 =getAllEmpNameAndGender();
	
Iterator itr =	list1.iterator();

while(itr.hasNext()) {
	Object[] obj = (Object[]) itr.next();
    System.out.println("name : " + obj[0]);
    System.out.println(" gender : "+obj[1]);
}
	
	
}

public static List<Integer> getAllId() {
	Session session = HibernateUtility.getSession();
	Criteria crit = session.createCriteria(Employee.class);
	crit.setProjection(Projections.property("id"));
	List<Integer> list = crit.list();
	return list;
}

public static List getAllEmpNameAndGender() {
	Session session = HibernateUtility.getSession();
	Criteria crit = session.createCriteria(Employee.class);
	 ProjectionList projectionList =Projections.projectionList();
	 projectionList.add(Projections.property("name"));
	 projectionList.add(Projections.property("gender"));
	crit.setProjection(projectionList);
	List list = crit.list();
	return list;
}
}
