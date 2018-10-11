package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateICoursesDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .buildSessionFactory();
									 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("start");
		
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan@lu2code.com");
			
			
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
			session.close();
			factory.close();		
		}

	}

}
