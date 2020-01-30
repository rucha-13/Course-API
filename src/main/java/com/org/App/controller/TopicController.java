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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.App.Model.Topic;
import com.org.App.ServiceImpl.TopicServiceImpl;

@RestController
public class TopicController {
	@Autowired
	private TopicServiceImpl topicServiceImpl;

	@RequestMapping("/message")
	public String getMessage() {
		return "My boot";
	}

	@RequestMapping("/topics")
	public List<Topic> getAllTopic() {
		return topicServiceImpl.getAllTopics();
	}

	@RequestMapping("/topic/{id}")
	public ResponseEntity<Object> getTopicById(@PathVariable("id") int id) {
		try {
			Topic topic = topicServiceImpl.getTopicById(id);
			if (topic != null) {
				return ResponseEntity.status(HttpStatus.OK).body(topic);
			}
		} catch (Exception ex) {

		}
		return ResponseEntity.badRequest().body("Invalid id");
	}

	@RequestMapping(value = "/topics", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteTopics() {
		topicServiceImpl.deleteTopics();
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/topic/{id}")
	public ResponseEntity<?> deleteTopicById(@PathVariable("id") int id) {
		topicServiceImpl.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PostMapping(value = "/topic", consumes = MediaType.APPLICATION_JSON_VALUE,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
		Topic top = topicServiceImpl.createTopic(topic);
		return new ResponseEntity<Topic>(top, HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/topic/{id}")
	public ResponseEntity<Topic> update(@RequestBody Topic topic, @PathVariable("id") int id) {
		Topic top = topicServiceImpl.updateTopic(topic);
		return new ResponseEntity<Topic>(top, HttpStatus.ACCEPTED);
	}
}
