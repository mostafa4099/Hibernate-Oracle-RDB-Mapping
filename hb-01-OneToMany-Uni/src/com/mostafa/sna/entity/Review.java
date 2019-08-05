package com.mostafa.sna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="review_id_increment")
	@SequenceGenerator(name="review_id_increment", sequenceName="review_id_increment", allocationSize=1, initialValue=1)
	@Column(name="id")
	private int id;
	
	@Column(name="comment_detail")
	private String comment;

	public Review() {
		
	}

	public Review(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
}
