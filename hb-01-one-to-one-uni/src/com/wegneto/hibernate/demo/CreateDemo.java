package com.wegneto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Instructor;
import com.wegneto.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			Instructor instructor = new Instructor("John", "Doe", "john@doe.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/channel", "Code");
			instructor.setInstructorDetail(instructorDetail);
			
			
			//start a transaction
			session.beginTransaction();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			System.out.println("Closing the connection.");
			factory.close();
		}

	}

}
