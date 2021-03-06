package com.example.wbdvsp20hesharonserverjava.services;

import com.example.wbdvsp20hesharonserverjava.repositories.*;
import com.example.wbdvsp20hesharonserverjava.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public int deleteWidget(Integer widgetId) {
        widgetRepository.deleteById(widgetId);
        return 1;
    }

    public Widget createWidget(int tid, Widget newWidget) {
        return widgetRepository.save(newWidget);
    }

    public int updateWidget(int widgetId, Widget updatedWidget) {
        Widget oldWidget = widgetRepository.findWidgetById(widgetId);
        oldWidget.setTitle(updatedWidget.getTitle());
        //oldWidget.setSize(updatedWidget.getSize());
        oldWidget.setType(updatedWidget.getType());
        oldWidget.setText(updatedWidget.getText());
        widgetRepository.save(oldWidget);
        return 0;
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAllWidgets();
    }

    public List<Widget> findWidgetsForTopic(int topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }

    public Widget findWidgetById(int wid) {
        return widgetRepository.findWidgetById(wid);
//        return widgetRepository.findById(wid).get();
    }
}
