package com.example.wbdvsp20hesharonserverjava.controllers;

import com.example.wbdvsp20hesharonserverjava.models.Topic;
import com.example.wbdvsp20hesharonserverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TopicController {

    @Autowired
    TopicService service = new TopicService();

    @PostMapping("/lessons/{lid}/topics")
    public Topic createTopic(
            @PathVariable("lid")
                    String lid, @RequestBody Topic newTopic) {
        return service.createTopic(lid, newTopic);
    }

    @DeleteMapping("/topics/{topicId}")
    public int deleteTopic(
            @PathVariable("topicId") int tid) {
        return service.deleteTopic(tid);
    }

    @PutMapping("/topics/{topicId}")
    public int updateTopic(
            @PathVariable("topicId") int tid,
            @RequestBody Topic updatedTopic) {
        Topic topic = service.findTopicById(tid);

        return service.updateTopic(tid, updatedTopic);
    }

    @GetMapping("/topics/{topicId}")
    public Topic findTopicById(
            @PathVariable("topicId") int tid) {
        return service.findTopicById(tid);
    }

    @GetMapping("/topics")
    public List<Topic> findAllTopics() {
        return service.findAllTopics();
    }

    @GetMapping("/lessons/{lid}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lid") String lessonId) {
        return service.findTopicsForLesson(lessonId);
    }

//    @GetMapping("/w1")
//    public Widget getWidget() {
//        Widget w1 = new Widget("123", "Widget A", "PARAGRAPH");
//        return w1;
//    }
//
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello World";
//    }
}
