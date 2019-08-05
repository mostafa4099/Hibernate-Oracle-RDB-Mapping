package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mostafa.sna.entity.Instructor;
import com.mostafa.sna.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id=2;
			
			System.out.println("Geting Instructor Detail");
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println("Instructor Detail "+detail);
			
			System.out.println("First Name Of Instructor "+detail.getInstructor().getFirstName());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
