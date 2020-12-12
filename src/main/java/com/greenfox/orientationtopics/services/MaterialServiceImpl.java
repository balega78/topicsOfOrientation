package com.greenfox.orientationtopics.services;

import com.greenfox.orientationtopics.models.Importance;
import com.greenfox.orientationtopics.models.Material;
import com.greenfox.orientationtopics.models.Topic;
import com.greenfox.orientationtopics.repositories.MaterialRepository;
import com.greenfox.orientationtopics.repositories.TopicRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

  private MaterialRepository materialRepository;

  private TopicRepository topicRepository;

  public MaterialServiceImpl(MaterialRepository materialRepository, TopicRepository topicRepository) {
    this.materialRepository = materialRepository;
    this.topicRepository=topicRepository;
  }

  @Override
  public Material findById(Integer materialId) {
    return materialRepository.findById(materialId).orElse(null);
  }

  @Override
  public List<Material> findAllMaterials() {
    return (List<Material>) materialRepository.findAll();
  }

  @Override
  public void createMaterial(String title, String url, String details, Importance importance, Integer topicId) {
    materialRepository.save(new Material(title, url, details, importance, topicRepository.findById(topicId).get()));
  }

  @Override
  public List<Material> findAllByTopic(Integer topicId) {
    return materialRepository.findAllByTopic(topicRepository.findById(topicId).get());
  }

  @Override
  public void deleteMaterial(Integer materialId) {
    materialRepository.deleteById(materialId);
  }

  @Override
  public void setMaterialDetails(Integer materialId, String details) {
    materialRepository.findById(materialId).get().setDetails(details);
  }

}
