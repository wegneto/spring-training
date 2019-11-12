package com.wegneto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Instructor;
import com.wegneto.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			int id = 2;
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			if (instructorDetail == null) {
				System.out.println("Instructor not found.");
			} else {
				System.out.println("Instructor detail: " + instructorDetail);
				System.out.println("Instructor: " + instructorDetail.getInstructor());
				
				instructorDetail.getInstructor().setInstructorDetail(null);
				
				session.delete(instructorDetail);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Closing the connection.");
			session.close();
			factory.close();
		}

	}

}
