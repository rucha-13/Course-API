package com.org.App.Service;

import java.util.List;

import com.org.App.Model.Topic;

public interface TopicService {
	
	public List<Topic> getAllTopics();
	public Topic getTopicById(int id);
	public void deleteTopics();
	public void deleteById(int id);
	public Topic createTopic(Topic topic);
	public Topic updateTopic(Topic topic);
}
