package com.greenfox.orientationtopics.controllers;

import com.greenfox.orientationtopics.models.Importance;
import com.greenfox.orientationtopics.services.MaterialService;
import com.greenfox.orientationtopics.services.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TopicController {
  private TopicService topicService;

  private MaterialService materialService;

  public TopicController(TopicService topicService, MaterialService materialService) {
    this.topicService = topicService;
    this.materialService = materialService;
  }

  @GetMapping("/")
  public String main() {
    return "main";
  }

  @GetMapping({"topic/", "topic"})
  public String listAllTopics(Model model) {
    model.addAttribute("topics", topicService.findAllTopics());
    return "index";
  }

  @GetMapping("topic/{topicId}")
  public String showTopic(Model model, @PathVariable("topicId") Integer topicId) {
    model.addAttribute("topic", topicService.findById(topicId));
    model.addAttribute("materials", materialService.findAllByTopic(topicId));
    return "topic";
  }

  @PostMapping({"topic/", "topic"})
  public String checkTopic(Integer topicId, Boolean checked) {
    topicService.setCheckedById(topicId, checked);
    return "redirect:topic";
  }

  @PostMapping({"topic/description/{topicId}"})
  public String changeDiscription(@PathVariable("topicId") Integer topicId, String description) {
    topicService.setDescriptionById(topicId, description);
    return "redirect:../" + topicId;
  }

  @PostMapping({"topic/copy-paste/{topicId}"})
  public String changeCopyPaste(@PathVariable("topicId") Integer topicId, String copyPaste) {
    topicService.setCopyPasteById(topicId, copyPaste);
    return "redirect:../" + topicId;
  }

  @PostMapping("topic/material/{topicId}")
  public String create(@PathVariable("topicId") Integer topicId, String title,
                       String details, String url, Importance importance) {
    materialService.createMaterial(title, url, details, importance, topicId);
    return "redirect:../" + topicId;
  }

  @PostMapping("topic/deletematerial/{topicId}")
  public String deleteMaterialById(@PathVariable("topicId") Integer topicId,
                                   @RequestParam Integer materialId) {
    materialService.deleteMaterial(materialId);
    return "redirect:../" + topicId;
  }

  @PostMapping("topic/changeDetails/{materialId}")
  public String changeMaterialDetailById(@PathVariable("topicId") Integer materialId,
                                         @RequestParam Integer topicId,
                                         @RequestParam String details) {
    materialService.setMaterialDetails(materialId, details);
    return "redirect:../" + topicId;
  }
}
