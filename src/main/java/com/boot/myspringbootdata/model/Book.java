package com.boot.myspringbootdata.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="BOOK_TAB")
@Getter
@Setter
@ToString
public class Book {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;

	/*
		Here only unidirectional OneToMany is implemented (ie there is no reference of Topic from the Book class).
		In case of bi-directional OneToMany, there is the problem of eager fetching
		(ie topic fetches book, book fetches topic and this goes on putting the process in infinite loop)
		Visit the link for more info.
		https://medium.com/monstar-lab-bangladesh-engineering/jpa-hibernate-bidirectional-lazy-loading-done-right-65eda6426d64
	 */
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id_prat")
	private Topic topic;*/
	
	/*
		Removed the hardcoded getter, setters and constructors with lombok annotations
	 */
	/*public Integer getId() {
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
	}*/
	
	
	/*@Override
	public String toString() {
		return "id: "+id+" name: "+name;
	}*/
	
}
