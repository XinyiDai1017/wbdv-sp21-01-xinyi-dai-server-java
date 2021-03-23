package com.example.wbdvsp2101xinyidaiserverjava.controllers;

import com.example.wbdvsp2101xinyidaiserverjava.models.Widget;
import com.example.wbdvsp2101xinyidaiserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;// = new WidgetService();

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") String tid,
            @RequestBody Widget widget) {
        widget.setTopicId(tid);
        return service.createWidget(tid, widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String tid
    ) {
        return service.findWidgetsForTopic(tid);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Long wid) {
        return service.findWidgetById(wid);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Long id) {
        return service.deleteWidget(id);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(
            @PathVariable("wid") Long id,
            @RequestBody Widget widget) {
        return service.updateWidget(id, widget);
    }
}