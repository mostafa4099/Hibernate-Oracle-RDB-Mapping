package com.mostafa.sna.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Courses {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_id_increment")
	@SequenceGenerator(name="course_id_increment", sequenceName="course_id_increment", allocationSize=1, initialValue=1)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name= "course_id")
	private List<Review> reviews;
	
	public Courses() {
		
	}

	public Courses(String title) {
		this.title = title;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	public void addReview(Review review) {
		
		if(this.reviews==null) {
			this.reviews = new ArrayList<Review>();
		}
		
		reviews.add(review);
		
	}
}
