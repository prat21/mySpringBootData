package com.boot.myspringbootdata.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TOPIC_TAB")
public class Topic {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String desc;
	
	/*@OneToMany(cascade=CascadeType.ALL)
	private List<Book> books;*/
	
	/*public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}*/


	public Topic() {
		// Required for Marshalling and Unmarshalling
	}
	
	
	public Topic(String name, String desc) {
		this.name = name;
		this.desc = desc;
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
