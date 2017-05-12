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

/**
 * Created by rafalstepien on 28/04/2017.
 */
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
        EventCategory category = eventCategoryDao.find(1);
        Event event = new Event(req.queryParams("ename"), req.queryParams("description"),
                date, category);
        eventDao.add(event);
    }

    public static void main(String[] args) {
        EventCategory eventCategory = eventCategoryDao.find(1);
        System.out.println(eventCategory);
        Event event = new Event("Cinema", "Films and beers", "14-05-2017", eventCategory );
        eventDao.add(event);

    }
}
