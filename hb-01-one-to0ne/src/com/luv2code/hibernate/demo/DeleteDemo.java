package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			System.out.println("instructor: " + instructor);
			
			if(instructor != null) {
				// delete as cascade
				session.delete(instructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done !!!");
		}
		finally {
			factory.close();
		}

	}

}
