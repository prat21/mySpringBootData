package com.boot.myspringbootdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.myspringbootdata.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
}
