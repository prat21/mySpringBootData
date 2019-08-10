package com.boot.myspringbootdata.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.myspringbootdata.model.Book;
import com.boot.myspringbootdata.model.Topic;
import com.boot.myspringbootdata.repository.BookRepository;
import com.boot.myspringbootdata.repository.TopicRepository;
import com.boot.myspringbootdata.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicRepository t;
	
	@Autowired
	private BookRepository b;
		
	@GetMapping("/topics")
	public List<Topic> getTopics(){
		return topicService.getAllTopics();
	}
	
	
	/*
	 * An Exception has been mapped for this URL. Try the URL "http://localhost:8080/topics/1" and see what happens.
	 * Also see the ExcpetionHandler at TopicControllerAdvice.
	 */
	@GetMapping("/topics/{name}")
	public Topic getTopic(@PathVariable Integer name) {
		return topicService.getTopic(name);
	}
	
	/*
	 * This method uses JPQL to fetch data.
	 */
	@GetMapping("/topics/desc/{desc}")
	public List<Topic> getTopicUsingDesc(@PathVariable String desc) {
		return topicService.findMyTopicUsingDesc(desc);
	}
	
	/*
	 * Delete these method later
	 */
	@GetMapping("/topics/test/{desc}")
	public List<Topic> Test(@PathVariable String desc) {
		return t.Test(desc);
	}
	
	/* This method adds a new book to the given topicid*/
	@PostMapping("/topicAddBook/{topicID}")
	public void topicAddNewBook(@RequestBody Book newBook, @PathVariable Integer topicID) {
		System.out.println(newBook.getName());
		topicService.topicAddNewBook(topicID,newBook);
	}
	
	/* This method adds an existing book(bookid) to the given topicid*/
	@PostMapping("/topicAddBook/{topicID}/book/{bookID}")
	public void topicAddExistingBook(@PathVariable Integer bookID, @PathVariable Integer topicID) {
		topicService.topicAddExistingBook(topicID,bookID);
	}
	
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		b.findAll().forEach(books::add);
		return books;
	}
	
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		b.save(book);
	}
	
	/*
	 * Delete these method later - end
	 */
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		//System.out.println(topic.getBooks());
		topicService.addTopic(topic);
	}
	
	
	@PutMapping("/topics")
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/topics/{name}")
	public void deleteTopic(@PathVariable Integer name) {
		topicService.deleteTopic(name);
	}
}
