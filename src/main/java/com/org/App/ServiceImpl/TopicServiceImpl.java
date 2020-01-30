package com.org.App.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.org.App.Model.Topic;
import com.org.App.Service.TopicService;
import com.org.App.repository.TopicRepository;

@Service
@Scope("singleton")
public class TopicServiceImpl implements TopicService {
	@Autowired
	TopicRepository topicRepo;
	
	@Override
	public List<Topic> getAllTopics() {
		List topicList = new ArrayList();
		topicRepo.findAll()
		.forEach(topicList ::add);
		return topicList;
	}

	@Override
	public  Topic getTopicById(int id) {
		return topicRepo.findById(id).get();
		
	}

	@Override
	public void deleteTopics() {
		 topicRepo.deleteAll();
	}
	
	@Override
	public void deleteById(int id) {
		topicRepo.deleteById(id);		 
	}

	@Override
	public Topic createTopic(Topic topic) {
		return topicRepo.save(topic);
	}

	@Override
	public Topic updateTopic(Topic topic) {
		return topicRepo.save(topic);
	}
}
