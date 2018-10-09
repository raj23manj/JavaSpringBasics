package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			//Student tempStudent = new Student("paul", "wall", "paul@luv2code.com");
			Student tempStudent1 = new Student("paul1", "wall1", "paul1@luv2code.com");
			Student tempStudent2 = new Student("paul2", "wall2", "paul2@luv2code.com");
			Student tempStudent3 = new Student("paul3", "wall3", "paul3@luv2code.com");
			
			
			//start begin the student transaction
			session.beginTransaction();
			// save the student object
			//session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done !!!");
		}
		finally {
			factory.close();
		}


	}

}
