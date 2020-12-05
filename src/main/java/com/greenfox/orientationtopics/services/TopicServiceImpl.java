package com.greenfox.orientationtopics.services;

import com.greenfox.orientationtopics.models.Topic;
import com.greenfox.orientationtopics.repositories.TopicRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService{

  private TopicRepository topicRepository;

  public TopicServiceImpl (TopicRepository topicRepository) {
    this.topicRepository=topicRepository;
  }

  @Override
  public Topic findById(Integer topicId) {
    return topicRepository.findById(topicId).orElse(null);
  }

  @Override
  public void setCheckedById(Integer topicId, Boolean checked) {
    Topic topic = findById(topicId);
    topic.setChecked(checked);
    topicRepository.save(topic);
  }

  @Override
  public void setDescriptionById(Integer topicId, String description) {
    Topic topic = findById(topicId);
    topic.setDescription(description);
    topicRepository.save(topic);
  }

  @Override
  public List<Topic> findAllTopics() {
    return (List<Topic>) topicRepository.findAll();
  }

  @Override
  public void createTopic(String title, String description) {
    topicRepository.save(new Topic(title, description));
  }

}
