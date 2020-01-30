package com.org.App.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	 @Id
	 @Column(name="courseId")
	 private int id;
	 private String Name;
	 private String description;
	 @ManyToOne
	 private Topic topic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public Course(int id, String name, String description, int topicId) {
		this.id = id;
		Name = name;
		this.description = description;
		this.topic = new Topic(topicId,"","");
	}
	 
	public Course() {}
}
