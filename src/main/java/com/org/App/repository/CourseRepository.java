package com.org.App.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.org.App.Model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
		//public Course findByTopicTopicId(int id);
		public List findByTopicTopicId(int id);
}
