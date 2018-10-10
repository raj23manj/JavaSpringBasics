package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			
//			cascade type delete bi directional
//			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
//			
//			System.out.println("instructor: " + instructorDetail.getInstructor().getFirstName());
//			
//			// 
//			session.delete(instructorDetail);
			
			// not delete on cascade
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			
			System.out.println("instructor: " + instructorDetail.getInstructor().getFirstName());
			
			// remove the associated object reference
			// break the link error: deleted object would be re-saved by cascade (remove deleted object from associations)
			
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			
//			
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
