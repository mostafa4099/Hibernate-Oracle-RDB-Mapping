package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Instructor;
import com.mostafa.sna.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Golam", "Mostafa", "mostafa.sna@gmail.com");
			InstructorDetail detail = new InstructorDetail("youtube.com/mostafa.sna", "Coding");
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			session.save(instructor);
			
			System.out.println(instructor.getId());
			System.out.println(instructor.getInstructorDetail().getId());
			
			System.out.println(instructor);
			System.out.println(instructor.getInstructorDetail());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
