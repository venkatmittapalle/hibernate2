package com.venki.hibernate;

import java.util.List;

import org.hibernate.Session;

public class HibernateStandAlone {
	
	@SuppressWarnings("unchecked")
	public static void main (String [] args) {
		
		Student student = new Student ("Venkat", "Mittapalle", "JEE");
		Address address = new Address ("1240 HighField Ct", "PA", "USA");
		Session session = HibernateUtil.getSessionFactroy().openSession();
		session.beginTransaction();
		session.persist(student);
		address.setId(student.getId());
		student.setAddress(address);
		session.save(student);
		session.getTransaction().commit();
		List<Student> students = (List<Student>)session.createQuery("from Student").list();
		
		for(Student s : students) {
			System.out.println("Details: " +s);
		}
		
		//students.forEach(System.out::println);
		session.close();
		
	}
	

	
	
}
