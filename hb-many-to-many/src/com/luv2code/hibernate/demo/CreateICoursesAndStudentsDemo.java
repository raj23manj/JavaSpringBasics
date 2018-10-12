package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateICoursesAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Review.class)
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
									 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			//start  transaction
			session.beginTransaction();
			System.out.println("start");
		
			Course tempCourse = new Course("Pacman");
			
			session.save(tempCourse);
			
			Student student1 = new Student("john", "Doe", "luv2code@gmail.com");
			Student student2 = new Student("sam", "dim", "dimcode@gmail.com");
			
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			
			session.save(student1);
			session.save(student2);
			
			System.out.println("students: " + tempCourse.getStudents());
			
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
