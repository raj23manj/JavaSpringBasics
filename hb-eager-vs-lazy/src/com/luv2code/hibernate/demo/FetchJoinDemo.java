package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = session.createQuery( 
														   "select i FROM Instructor i " +
														   "JOIN FETCH i.courses " +
														   "where i.id=:theInstructorId"		   
														  ,Instructor.class
														  );
			
			//set query parameter
			query.setParameter("theInstructorId", theId);
			
			Instructor instructor = query.getSingleResult();
			
			
			System.out.println("afterQuery: " );
			System.out.println("l2c:instructor: " + instructor);
			
			System.out.println("l2c:Courses: " + instructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("After Session: " );
			System.out.println("l2c:instructor: " + instructor);
			
			System.out.println("l2c:Courses: " + instructor.getCourses());
			
			System.out.println("l2c:done !!!");
		}
		finally {
			session.close();
			factory.close();		
		}
		
		
		
		

	}

}
