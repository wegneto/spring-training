package com.wegneto.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			
			System.out.println("-- display all students --");
			List<Student> students = session.createQuery("from Student").list();
			displayStudents(students);
			
			System.out.println("-- display all students with last name of One --");
			students = session.createQuery("from Student s where s.lastName = 'One'").list();
			displayStudents(students);
			
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
