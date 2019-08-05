package com.mostafa.sna.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mostafa.sna.entity.Courses;
import com.mostafa.sna.entity.Instructor;
import com.mostafa.sna.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Courses.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 2;

			Query<Instructor> query = session.createQuery(
							"select i from Instructor i JOIN FETCH i.courses where i.id=:id",
							Instructor.class);

			query.setParameter("id", id);

			Instructor instructor = query.getSingleResult();

			System.out.println("Luv2code: Instructor " + instructor);

			session.getTransaction().commit();

			session.close();

			System.out.println("\nLuv2code: Session Close\n");

			System.out.println("Luv2code: Course " + instructor.getCourses());

			System.out.println("Luv2code: Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
