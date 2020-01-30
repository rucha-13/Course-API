package com.org.App.Service;

import java.util.List;

import com.org.App.Model.Course;

public interface CourseService {
	  public List<Course> getAllCourses(int topicId);
	  public Course getCourseById(int courseId); 
	  public void deleteCourses();
	  public void deleteCourseById(int courseId); 
	  public Course createCourse(Course course); 
	  public Course updateCourse(Course course);
	 }
