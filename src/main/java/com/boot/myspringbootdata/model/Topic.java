package com.boot.myspringbootdata.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="TOPIC_TAB")
public class Topic {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String name;
	private String desc;

	/*
		Here only unidirectional OneToMany is implemented (ie there is no reference of Topic from the Book class).
		In case of bi-directional OneToMany, there is the problem of eager fetching
		(ie topic fetches book, book fetches topic and this goes on putting the process in infinite loop)
		Visit the link for more info.
		https://medium.com/monstar-lab-bangladesh-engineering/jpa-hibernate-bidirectional-lazy-loading-done-right-65eda6426d64
	 */
	//@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id")
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public Topic() {
		// Required for Marshalling and Unmarshalling
	}


	public Integer getId() {
		return id;
	}	
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
