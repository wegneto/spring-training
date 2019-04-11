package com.wegneto.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//start a transaction
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Deleting a student...");
			//session.delete(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			//start a transaction
			session.beginTransaction();
			
			System.out.println("Deleting student with id == 2");
			session.createQuery("delete Student where id = 2").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			System.out.println("Closing the connection.");
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
