package com.boot.myspringbootdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.myspringbootdata.model.Topic;

@Service
public class TopicService {
	List<Topic> allTopics = new ArrayList<Topic>();
	
	public TopicService() {
		System.out.println("Inside TopicService Cons");
		allTopics.add(new Topic("topic1","desc1"));
		allTopics.add(new Topic("topic2","desc2"));
	}
	
	public List<Topic> getAllTopics(){
		return allTopics;
	}

	public Topic getTopic(String name) {
		return allTopics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		allTopics.add(new Topic(topic.getName(),topic.getDesc()));		
	}

	public String updateTopic(String name,Topic newTopic) {
		Topic oldTopic = allTopics.stream().filter(t -> t.getName().equals(name)).findFirst().get();
		oldTopic.setDesc(newTopic.getDesc());
		
		return "Updated Successfully";
	}

	public String deleteTopic(String name) {
		allTopics.removeIf(t -> t.getName().equals(name));
		return "Delete Successful";
	}
}
