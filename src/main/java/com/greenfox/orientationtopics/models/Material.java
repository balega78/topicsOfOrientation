package com.greenfox.orientationtopics.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "materials")
public class Material {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  private String url;
  private Importance importance;

  @ManyToOne
  @JoinColumn(name = "topicId")
  private Topic topic;

  public Topic getTopic() {
    return topic;
  }

  public String getTitle() {
    return title;
  }

  public Material() {
  }

  public Material(String title, String url, Importance importance, Topic topic) {
    this.title = title;
    this.url=url;
    this.importance=importance;
    this.topic=topic;
  }
}
