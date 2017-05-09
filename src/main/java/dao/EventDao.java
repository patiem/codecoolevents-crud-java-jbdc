package dao;


import model.Event;
import model.EventCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EventDao {

    public void add(Event event) {
    }


    public Event find(int id) {
        Event event = null;
        return event;
    }

    public void remove(int id) {

    }

    public List<Event> getAll() {

        List<Event> events = new ArrayList<Event>();
        return events;
    }

    public List<Event> getBy(EventCategory eventCategory) {
        List<Event> events = new ArrayList<Event>();

        return events;

    }


}
