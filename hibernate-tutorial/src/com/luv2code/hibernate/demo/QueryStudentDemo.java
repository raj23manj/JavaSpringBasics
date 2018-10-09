package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			
			System.out.println("start");
			
			//start begin the student transaction
			session.beginTransaction();
			
			// query students
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
 			
			//query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
//			//commit transaction
//			session.getTransaction().commit();
//			
			System.out.println("lastname duck !!!");
			displayStudents(theStudents);
			
			//query students with or condition
			theStudents = session.createQuery(" from Student s where s.firstName='paul' OR s.lastName='paul3'").getResultList();
			
			System.out.println("or condition!!!");
			displayStudents(theStudents);
			
			
			//query students with or condition
			theStudents = session.createQuery(" from Student s where s.email like '%luv2code.com'").getResultList();
			
			System.out.println("email like!");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("done !!!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		// display the students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
