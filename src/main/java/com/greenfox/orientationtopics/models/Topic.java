package com.greenfox.orientationtopics.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "topics")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer topicId;
  private String title;
  private String description;
  private String copyPaste;
  private Boolean checked;

  @OneToMany(mappedBy = "topic")
  private List<Material> materialList;

  public Topic() {
  }

  public Topic(String title, String description) {
    this.title = title;
    this.description = description;
    this.checked=false;
  }

 /* public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  public void setDescription(String description) {
    this.description = description;
  }*/
}
