package com.org.App.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.App.Model.Course;
import com.org.App.Service.CourseService;
import com.org.App.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public List<Course> getAllCourses(int topicId) {
		List <Course> courseList = new ArrayList <Course>();
		return courseRepo.findByTopicTopicId(topicId);
		//return courseList;
	}

	@Override
	public Course getCourseById(int courseId) {
		return courseRepo.findById(courseId).get();
		
	}

	@Override
	public void deleteCourses() {
		courseRepo.deleteAll();
	}

	@Override
	public void deleteCourseById(int courseId) {
		courseRepo.deleteById(courseId);
		
	}

	@Override
	public Course createCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}

	
}
