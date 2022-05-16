package com.wegneto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create 3 studend objects
			System.out.println("Creating 3 student objects...");
			Student student1 = new Student("Paul", "McCartney ", "paul@beatles.com");
			Student student2 = new Student("Ringo", "Starr", "ringo@beatles.com");
			Student student3 = new Student("George", "Harrison", "george@beatles.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done saving the students.");
		} finally {
			System.out.println("Closing the connection.");
			factory.close();
		}

	}

}
