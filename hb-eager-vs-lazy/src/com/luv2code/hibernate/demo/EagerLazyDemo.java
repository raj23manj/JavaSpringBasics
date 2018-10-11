package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			//start  transaction
			session.beginTransaction();
			
			System.out.println("l2c:start");
		
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("l2c:instructor: " + instructor);
			
			System.out.println("l2c:running: " );
			
			System.out.println("l2c:Courses: " + instructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("after: " );
			
			
			System.out.println("l2c:Courses: " + instructor.getCourses());
			
			System.out.println("l2c:done !!!");
		}
		
		finally {
			session.close();
			factory.close();		
		}

	}

}






