package dao;


import model.Event;
import model.EventCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EventDao extends BaseDao {

    public void add(Event event) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement("INSERT INTO events" +
                    "(eventName, description, eventDate, category_id)" +
                    "VALUES (?, ?, ?, ?)");
            statement.setString(1, event.getName());
            statement.setString(2, event.getDescription());
            statement.setString(3, event.simpleStringFromDate());
            statement.setInt(4, event.getEventCategory().getId());
            statement.execute();

        } catch (SQLException e ) {
            e.printStackTrace();

        }
    }


    public Event find(int id) {
//        Event event = null;
        List<Event> events = new ArrayList<Event>();

        try {
            PreparedStatement statement = this.getConnection().
                    prepareStatement("SELECT * FROM events WHERE id = ?");
            statement.setInt(1, id);
            events = this.getEvents(statement);
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return events.get(0);
    }

    public void remove(int id) {

    }

    public List<Event> getAll() {

        List<Event> events = new ArrayList<Event>();
        try {
            PreparedStatement statement = this.getConnection().
                    prepareStatement("SELECT * FROM events");
            events = this.getEvents(statement);
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return events;
    }


    public List<Event> getBy(EventCategory eventCategory) {
        List<Event> events = new ArrayList<Event>();

        try {
            PreparedStatement statement = this.getConnection().
                    prepareStatement("SELECT * FROM events WHERE category_id = ?");
            statement.setInt(1, eventCategory.getId());
            events = this.getEvents(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }


    private List<Event> getEvents(PreparedStatement statement) throws SQLException {
        List<Event> events = new ArrayList<Event>();
        EventCategory category;
        EventCategoryDao eventCategoryDao = new EventCategoryDao();

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            category = eventCategoryDao.find(rs.getInt("category_id"));
            Event event = new Event(
                    rs.getString("eventName"),
                    rs.getString("description"),
                    rs.getString("eventDate"),
                    category);
            event.setId(rs.getInt("id"));
            events.add(event);
        }

        return events;
    }


}
