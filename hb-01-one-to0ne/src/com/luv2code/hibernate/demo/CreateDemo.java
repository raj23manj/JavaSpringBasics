package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

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
			
//			// use session object to save
//			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@lu2code.com");
//			
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail(
//																			"http://www.luv2code.com/youtube",
//																			"Luv 2 Code!!!"
//																		);
			
			// use session object to save
			Instructor tempInstructor = new Instructor("Chad1", "Darby1", "darby1@lu2code.com");
			
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
																			"http://www.luv2code.com/youtube",
																			"Luv 2 Code!!!"
																		);
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start  transaction
			session.beginTransaction();
			
			// cascade save
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done !!!");
		}
		finally {
			factory.close();
		}

	}

}
