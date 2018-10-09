package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
									 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
//			int studentId = 1;
//			System.out.println("fetching student: " + studentId);
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			Student s1 = session.get(Student.class, studentId);
//			System.out.println("s1: " + s1.toString());
//			
//			session.delete(s1);
			
			// alternate way to delete
			session.createQuery("delete Student s where id=2").executeUpdate();
			// commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}

	}

}
