package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
									 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			System.out.println("fetching student: " + studentId);
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student s1 = session.get(Student.class, studentId);
			System.out.println("s1: " + s1.toString());
			
			s1.setFirstName("Scooby");						
			// commit the transaction
			session.getTransaction().commit();
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			// commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
