package com.example.wbdvsp20hesharonserverjava.repositories;

import com.example.wbdvsp20hesharonserverjava.models.Topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

    @Query(value = "SELECT * FROM topics", nativeQuery = true)
    List<Topic> findAllTopics();

    @Query(value = "SELECT * FROM topics WHERE topics.lesson_id=:lessonId", nativeQuery = true)
    List<Topic> findTopicsForLesson
            (@Param("lessonId") String lessonId);

    @Query(value = "SELECT * FROM topics WHERE topics.id=:topicId", nativeQuery = true)
    Topic findTopicById
            (@Param("topicId") int topicId);
}
