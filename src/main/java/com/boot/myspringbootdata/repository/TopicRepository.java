package com.boot.myspringbootdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.myspringbootdata.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, String>{

}
