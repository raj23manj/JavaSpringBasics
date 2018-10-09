package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
									 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save
			
			// create Student object
			System.out.println("start");
			Student tempStudent = new Student("Daffy1", "Duck1", "daff1y@luv2code.com");
			
			//start begin the student transaction
			session.beginTransaction();
			// save the student object
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done !!! now retriving");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student s1 = session.get(Student.class, tempStudent.getId());
			System.out.println("s1: " + s1.toString());
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
