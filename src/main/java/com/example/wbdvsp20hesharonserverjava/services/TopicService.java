package com.example.wbdvsp20hesharonserverjava.services;

import com.example.wbdvsp20hesharonserverjava.models.*;
import com.example.wbdvsp20hesharonserverjava.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public List<Topic> findAllTopics() {
        return (List<Topic>)topicRepository.findAll();
    }

    // TODO: implement findTopicById
    public Topic findTopicById(int tid) {

        return topicRepository.findTopicById(tid);
    }

    // TODO: delete topic
    public int deleteTopic(int tid) {
        topicRepository.deleteTopic(tid);
        return 0;
    }

    public int updateTopic(int tid, Topic newTopic) {
        return 1;
    }

    public Topic createTopic(String lid, Topic newTopic) {
        return topicRepository.save(newTopic);
    }

    public Widget createWidgetForTopic(
            Integer tid,
            Widget newWidget) {
        Topic topic = topicRepository.findById(tid).get();
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        System.out.println(lessonId);
        return topicRepository.findTopicsForLesson(lessonId);
    }
}
