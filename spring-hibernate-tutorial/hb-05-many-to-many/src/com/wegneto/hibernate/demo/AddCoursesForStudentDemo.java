package com.wegneto.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wegneto.hibernate.demo.entity.Course;
import com.wegneto.hibernate.demo.entity.Instructor;
import com.wegneto.hibernate.demo.entity.InstructorDetail;
import com.wegneto.hibernate.demo.entity.Review;
import com.wegneto.hibernate.demo.entity.Student;

public class AddCoursesForStudentDemo {

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

			Course course = new Course("Course " + System.currentTimeMillis());

			// save the course
			System.out.println("Saving the course..");
			session.save(course);
			System.out.println("Saved the course: " + course);

			// create the students
			Student student1 = new Student("John", "Doe", "john@email.com");
			Student student2 = new Student("Mary", "Doe", "mary@email.com");
			
			// add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("Saving students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + course.getStudents());
			
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
