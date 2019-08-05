package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Courses;
import com.mostafa.sna.entity.Instructor;
import com.mostafa.sna.entity.InstructorDetail;
import com.mostafa.sna.entity.Review;
import com.mostafa.sna.entity.Student;

public class AddCourseForStudentDemo {

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
			int id=2;
			
			System.out.println("Getting Student....");
			Student st = session.get(Student.class, id);
			System.out.println("Student name is "+st.getLastName());
			System.out.println("Student course are "+st.getCourses());
			
			Courses course = new Courses("MySQL");
			Courses course2 = new Courses("SQL");
			
			course.addStudent(st);
			course2.addStudent(st);
			
			session.save(course);
			session.save(course2);
			
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
