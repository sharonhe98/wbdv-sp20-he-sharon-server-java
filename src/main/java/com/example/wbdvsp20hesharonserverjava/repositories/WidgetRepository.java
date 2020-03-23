package com.example.wbdvsp20hesharonserverjava.repositories;

import com.example.wbdvsp20hesharonserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

    @Query(value ="SELECT * FROM widgets WHERE widgets.id=:widgetId", nativeQuery = true)
    public Widget findWidgetById(
            @Param("widgetId") int wid);

    @Query(value = "SELECT * FROM widgets", nativeQuery = true)
    public List<Widget> findAllWidgets();

    // "SELECT * FROM widgets WHERE topic_id=topicId
//    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    @Query(value="SELECT * from widgets where widgets.topic_id=:tid", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(
            @Param("tid") int topicId);
}
