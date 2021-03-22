package com.example.wbdvsp2101xinyidaiserverjava.services;

import com.example.wbdvsp2101xinyidaiserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();
//    {
//        Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Welcome to Widgets");
//        Widget w2 = new Widget(234l, "ABC234", "PARAGRAPH", 1, "This is a paragraph");
//        Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Welcome to WebDev");
//        Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem ipsum");
//        widgets.add(w1);
//        widgets.add(w2);
//        widgets.add(w3);
//        widgets.add(w4);
//    }
    // implement crud operations
    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);
        widget.setId((int) (new Date()).getTime());
        widgets.add(widget);
        return widget;
    }
    public List<Widget> findAllWidgets() {
        return widgets;
    }
    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> ws = new ArrayList<Widget>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(tid)) {
                ws.add(w);
            }
        }
        return ws;
    }
    public Widget findWidgetById(Long wid) {
        for(Widget w: widgets) {
            if(w.getId().equals(wid)) {
                return w;
            }
        }
        return null;
    }
    public int updateWidget(String wid, Widget newWidget) {
        for(int i=0; i<widgets.size(); i++) {
            Widget w = widgets.get(i);
            if(w.getId().equals(wid)) {
                widgets.set(i, newWidget);
                return 1;
            }
        }
        return -1;
    }
    public int deleteWidget(String wid) {
        int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            if(widgets.get(i).getId().equals(wid)) {
                index = i;
                widgets.remove(index);
                return 1;
            }
        }
        return -1;
    }
}
