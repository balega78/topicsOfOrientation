package com.greenfox.orientationtopics.services;

import com.greenfox.orientationtopics.models.Topic;
import java.util.List;

public interface TopicService {
  public Topic findById(Integer topicId);
  public void setCheckedById (Integer topicId, Boolean checked);
  public void setDescriptionById (Integer topicId, String description);
  public void setCopyPasteById (Integer topicId, String copyPaste);
  public List<Topic> findAllTopics();
  public void createTopic(String title, String description);

}
