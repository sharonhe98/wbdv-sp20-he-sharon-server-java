package com.example.wbdvsp20hesharonserverjava.controllers;

import com.example.wbdvsp20hesharonserverjava.models.Widget;
import com.example.wbdvsp20hesharonserverjava.services.TopicService;
import com.example.wbdvsp20hesharonserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service = new WidgetService();

    @Autowired
    TopicService topicService = new TopicService();

    @PostMapping("/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid")
            int tid, @RequestBody Widget newWidget) {
        System.out.println("CREATE WIDGET CONTROLLER");
        return topicService.createWidgetForTopic(tid, newWidget);
    }

    @DeleteMapping("/widgets/{widgetId}")
    public int deleteWidget(
            @PathVariable("widgetId") int wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") int wid,
            @RequestBody Widget updatedWidget) {
        return service.updateWidget(wid, updatedWidget);
    }

    @GetMapping("/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") int wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") int topicId) {
        return service.findWidgetsForTopic(topicId);
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
