package com.boot.myspringbootdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.boot.myspringbootdata.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer>{
	@Query("select t from Topic t where t.desc = :desc")
	List<Topic> findMyTopicUsingDesc(@Param("desc") String desc);
	
	@Query("select t from Topic t,Book b where t.id=b.id and t.desc = :desc")
	List<Topic> Test(@Param("desc") String desc);
}
