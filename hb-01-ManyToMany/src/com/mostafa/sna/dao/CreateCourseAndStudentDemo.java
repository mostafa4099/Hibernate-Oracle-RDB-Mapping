package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Courses;
import com.mostafa.sna.entity.Instructor;
import com.mostafa.sna.entity.InstructorDetail;
import com.mostafa.sna.entity.Review;
import com.mostafa.sna.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Courses.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Courses courses = new Courses("Ruby");
			System.out.println("Course saving....");
			session.save(courses);
			System.out.println("Course saved! "+courses);
			
			Student student = new Student("Golam", "Mostafa", "mostafa.sna@gmail.com");
			Student student2 = new Student("Mostafa", "Rahman", "mostafa.rahman@gmail.com");
			
			System.out.println("Adding student to course");
			courses.addStudent(student);
			courses.addStudent(student2);
			System.out.println("Student added to course! "+courses);
			
			System.out.println("Student saving....");
			session.save(student);
			session.save(student2);
			System.out.println("Student saved! "+student);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
