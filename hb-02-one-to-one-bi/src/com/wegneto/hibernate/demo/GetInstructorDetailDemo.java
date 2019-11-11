package com.wegneto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Instructor;
import com.wegneto.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			int id = 1;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor detail: " + instructorDetail);
			
			System.out.println("Instructor: " + instructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			System.out.println("Closing the connection.");
			factory.close();
		}

	}

}
