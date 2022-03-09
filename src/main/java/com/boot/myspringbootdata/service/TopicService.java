package com.boot.myspringbootdata.service;

import com.boot.myspringbootdata.model.Book;
import com.boot.myspringbootdata.model.Topic;
import com.boot.myspringbootdata.repository.BookRepository;
import com.boot.myspringbootdata.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);			//Java 8 Method Reference
		//or topicRepository.findAll().forEach(topic -> topics.add(topic));		//Lambda Expression
		return topics;
	}

	public Topic getTopic(Integer id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic newTopic) {
		topicRepository.save(newTopic);
	}

	public void deleteTopic(Integer name) {
		topicRepository.deleteById(name);
	}

	public List<Topic> findMyTopicUsingDesc(String desc) {
		return topicRepository.findMyTopicUsingDesc(desc);
	}

	public void topicAddNewBook(Integer topicID, Book newBook) {
		Topic topic = topicRepository.findById(topicID).get();
		topic.getBooks().add(newBook);
		topicRepository.save(topic);
	}

	public void topicAddExistingBook(Integer topicID, Integer bookID) {
		Topic topic = topicRepository.findById(topicID).get();
		Book book = bookRepository.findById(bookID).get();
		topic.getBooks().add(book);

		topicRepository.save(topic);
	}
}
