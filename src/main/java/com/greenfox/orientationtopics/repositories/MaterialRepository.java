package com.greenfox.orientationtopics.repositories;

import com.greenfox.orientationtopics.models.Material;
import com.greenfox.orientationtopics.models.Topic;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Integer> {

  List<Material> findAllByTopic(Topic topic);

}
