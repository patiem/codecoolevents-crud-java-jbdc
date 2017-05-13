package controller;

import dao.EventCategoryDao;
import dao.EventDao;
import model.Event;
import model.EventCategory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventController {

    static EventCategoryDao eventCategoryDao = new EventCategoryDao();
    static EventDao eventDao = new EventDao();

    public static ModelAndView renderEvents(Request req, Response res) {
        //Get events from database by Dao
        List<Event> events = eventDao.getAll();
        Map params = new HashMap<>();
        params.put("eventsList", events);
        return new ModelAndView(params, "product/index");
    }

    public static ModelAndView addNewEvent(Request req, Response res) {
        Map params = new HashMap<>();
        return new ModelAndView(params, "product/add");
    }

    public static void saveNewEvent(Request req, Response res) {
        Date date = Event.makeDateFromForm(req.queryParams("edate"));
        EventCategory category = eventCategoryDao.find(Integer.parseInt(req.queryParams("category")));
        Event event = new Event(req.queryParams("ename"), req.queryParams("description"),
                date, category);
        if (!req.queryParams("elink").equals(null)) {
            event.setLink(req.queryParams("elink"));
        }
        eventDao.add(event);
    }

    public static void deleteEvent(Request req, Response res) {
        Integer id = Integer.parseInt(req.queryParams("delete"));
        eventDao.remove(id);
    }

    public static ModelAndView updateEventRender(Request req, Response res) {
        Map params = new HashMap<>();
        Integer id = Integer.parseInt(req.params(":id"));
        Event event = eventDao.find(id);
        params.put("id", id);
        params.put("event", event);
        System.out.println(event.simpleStringDate());
        return new ModelAndView(params, "product/update");
    }


    public static void updateEvent(Request req, Response res) {
        Integer id = Integer.parseInt(req.queryParams("eventId"));
        Event event = eventDao.find(id);
        event.setEventCategory(eventCategoryDao.find(Integer.parseInt(req.queryParams("category"))));
        event.setEventDate(Event.makeDateFromForm(req.queryParams("edate")));
        event.setDescription(req.queryParams("description"));
        event.setName(req.queryParams("ename"));
        event.setLink(req.queryParams("elink"));
        eventDao.update(event);
    }

    public static void updateEvent2(Request req, Response res) {
        eventDao.update(Integer.parseInt(req.queryParams("eventId")), req.queryParams("ename"),
                req.queryParams("description"), req.queryParams("edate"), Integer.parseInt(req.queryParams("category")));
    }
}