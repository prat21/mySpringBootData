package com.boot.myspringbootdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.myspringbootdata.model.Topic;
import com.boot.myspringbootdata.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);			//Java 8 Method Reference
		//or topicRepository.findAll().forEach(topic -> topics.add(topic));		//Lambda Expression
		return topics;
	}

	public Topic getTopic(String name) {
		return topicRepository.findById(name).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic newTopic) {
		topicRepository.save(newTopic);
	}

	public void deleteTopic(String name) {
		topicRepository.deleteById(name);
	}
}
