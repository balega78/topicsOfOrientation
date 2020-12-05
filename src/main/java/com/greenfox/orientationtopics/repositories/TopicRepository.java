package com.greenfox.orientationtopics.repositories;

import com.greenfox.orientationtopics.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
