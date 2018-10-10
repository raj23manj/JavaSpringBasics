package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
									 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("start");
				
			//start  transaction
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 23);
			
			System.out.println("instructor: " + instructorDetail.getInstructor().getFirstName());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done !!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
