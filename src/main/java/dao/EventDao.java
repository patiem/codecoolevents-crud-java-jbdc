package dao;


import model.Event;
import model.EventCategory;

import java.sql.PreparedStatement;
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

    private List<Event> getEvents(PreparedStatement statement) throws SQLException {
        List<Event> events = new ArrayList<Event>();
        EventCategory category;
        EventCategoryDao eventCategoryDao = new EventCategoryDao();

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            category = EventCategoryDao.find(rs.getInt("category_id"));
            Event event = new Event(
                    rs.getString("eventName"),
                    rs.getString("description"),
                    rs.getString("eventDate"),
                    category);
            );
            event.setId(rs.getInt("id"));
            events.add(event);
        }

        return events;
    }


}
