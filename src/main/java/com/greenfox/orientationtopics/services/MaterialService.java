package com.greenfox.orientationtopics.services;

import com.greenfox.orientationtopics.models.Importance;
import com.greenfox.orientationtopics.models.Material;
import java.util.List;

public interface MaterialService {
  public Material findById(Integer materialId);
  public List<Material> findAllMaterials();
  public void createMaterial (String title, String url, String details, Importance importance, Integer topicId);
  public List<Material> findAllByTopic(Integer TopicId);
  public void deleteMaterial (Integer materialId);
  public void setMaterialDetails(Integer materialId, String details);
}
