package com.example.wbdvsp2101xinyidaiserverjava.services;

import com.example.wbdvsp2101xinyidaiserverjava.models.Widget;
import com.example.wbdvsp2101xinyidaiserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

//     private List<Widget> widgets = new ArrayList<Widget>();
//    {
//        Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to Widgets");
//        Widget w2 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to Widgets");
//        Widget w3 = new Widget(234l, "ABC234", "PARAGRAPH", 1, "This is a paragraph");
//        Widget w4 = new Widget(345l, "ABC234", "HEADING", 2, "Welcome to WebDev");
//        Widget w5 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem ipsum");
//        widgets.add(w1);
//        widgets.add(w2);
//        widgets.add(w3);
//        widgets.add(w4);
//        widgets.add(w5);
//    }

    // implement crud operations
    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);
        return repository.save(widget);
//        widget.setId((new Date()).getTime());
//        widgets.add(widget);
//        return widget;
    }
    public List<Widget> findAllWidgets() {
        return  (List<Widget>) repository.findAll();
//        return widgets;
    }
    public List<Widget> findWidgetsForTopic(String tid) {
        return repository.findWidgetForTopic(tid);
//        List<Widget> ws = new ArrayList<Widget>();
//        for(Widget w: widgets) {
//            if(w.getTopicId().equals(tid)) {
//                ws.add(w);
//            }
//        }
//        return ws;
    }
    public Widget findWidgetById(Long wid) {
        return repository.findWidgetById(wid);
//        for(Widget w: widgets) {
//            if(w.getId().equals(wid)) {
//                return w;
//            }
//        }
//        return null;
    }
    public int updateWidget(Long id, Widget newWidget) {
        Widget originalWidget = repository.findById(id).get();
        // TODO: copy all the other fields testing for null
        if(newWidget.getText() != null){
            originalWidget.setText(newWidget.getText());
        }
        if(newWidget.getTopicId() !=null){
            originalWidget.setTopicId(newWidget.getTopicId());
        }
        if(newWidget.getName() !=null){
            originalWidget.setName(newWidget.getName());
        }
        if(newWidget.getType() !=null){
            originalWidget.setType(newWidget.getType());
        }
        if(newWidget.getWidgetOrder() !=null){
            originalWidget.setWidgetOrder(newWidget.getWidgetOrder());
        }
        if(newWidget.getCssClass() != null){
            originalWidget.setCssClass(newWidget.getCssClass());
        }
        if(newWidget.getHeight() != null){
            originalWidget.setHeight(newWidget.getHeight());
        }
        if(newWidget.getWidth() != null){
            originalWidget.setWidth(newWidget.getWidth());
        }
        if(newWidget.getSrc() != null){
            originalWidget.setSrc(newWidget.getSrc());
        }
        if(newWidget.getUrl() != null){
            originalWidget.setUrl(newWidget.getUrl());
        }
        if(newWidget.getHref() != null){
            originalWidget.setHref(newWidget.getHref());
        }
        if(newWidget.getSize() != null){
            originalWidget.setSize(newWidget.getSize());
        }
        if(newWidget.getStyle() != null){
            originalWidget.setStyle(newWidget.getStyle());
        }
        if(newWidget.getValue() != null){
            originalWidget.setValue(newWidget.getValue());
        }

        repository.save(originalWidget);
        return 1;
//        for(int i=0; i<widgets.size(); i++) {
//            Widget w = widgets.get(i);
//            if(w.getId().equals(id)) {
//                widgets.set(i, newWidget);
//                return 1;
//            }
//        }
//        return -1;
    }
    public int deleteWidget(Long id) {
        repository.deleteById(id);
//        int index = -1;
//        for(int i=0; i<widgets.size(); i++) {
//            if(widgets.get(i).getId().equals(id)) {
//                index = i;
//                widgets.remove(index);
//                return 1;
//            }
//        }
//        return -1;
        return 1;
    }
}
