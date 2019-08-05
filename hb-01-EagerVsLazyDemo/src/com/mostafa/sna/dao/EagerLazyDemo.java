package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Courses;
import com.mostafa.sna.entity.Instructor;
import com.mostafa.sna.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Courses.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id=2;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Luv2code: Instructor "+instructor);
			
			System.out.println("Luv2code: Course "+instructor.getCourses());
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("\nLuv2code: Session Close\n");
			
			System.out.println("Luv2code: Course "+instructor.getCourses());
			
			System.out.println("Luv2code: Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
