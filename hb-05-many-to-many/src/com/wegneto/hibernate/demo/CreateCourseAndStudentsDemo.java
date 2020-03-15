package com.wegneto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Course;
import com.wegneto.hibernate.demo.entity.Instructor;
import com.wegneto.hibernate.demo.entity.InstructorDetail;
import com.wegneto.hibernate.demo.entity.Review;
import com.wegneto.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get student from database
			int studentId = 1;
			Student student = session.get(Student.class, studentId);
			
			System.out.println("Student: " + student);
			System.out.println("Courses: " + student.getCourses());
			
			// create more courses
			Course course1 = new Course("Course 1");
			Course course2 = new Course("Course 2");
			
			// add student to curses
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			System.out.println("Saving the courses...");
			session.save(course1);
			session.save(course2);
			
			// commit transaction
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
