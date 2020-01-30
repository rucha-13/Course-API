package com.org.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.App.Model.Course;
import com.org.App.Model.Topic;
import com.org.App.Service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseSer;
	
	@RequestMapping("/topics/{id}/courses")
	public ResponseEntity<List<Course>> getAllCourse(@PathVariable int id) {
		List<Course> courses = courseSer.getAllCourses( id);
		return new ResponseEntity<List<Course>>(courses , HttpStatus.FOUND);
	}
	
	@RequestMapping("/courses/{id}")
	public ResponseEntity getCourseById(@PathVariable int id) {
		Course course = courseSer.getCourseById(id);
		return new ResponseEntity(course,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/courses")
	public ResponseEntity deleteAllCourses() {
		courseSer.deleteCourses();
		return new ResponseEntity("All courses deleted successfuly",HttpStatus.FOUND);
	}
	
	@PostMapping(path = "/topics/{topicId}/course",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity addCourse(@RequestBody Course course,@PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		Course courseNew = courseSer.createCourse(course);
		return ResponseEntity.accepted().body(courseNew);
	}
	
	@PutMapping("/course")
	public ResponseEntity updateCourse(@RequestBody Course course) {
		Course courseNew = courseSer.updateCourse(course);
		return ResponseEntity.accepted().body(courseNew);
	}
	
}
