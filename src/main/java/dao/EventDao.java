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
                    "(eventName, description, eventDate, category_id, link)" +
                    "VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, event.getName());
            statement.setString(2, event.getDescription());
            statement.setString(3, event.simpleStringFromDate());
            statement.setInt(4, event.getEventCategory().getId());
            statement.setString(5, event.getLink());

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
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(
                    "DELETE FROM events WHERE id=?");
            statement.setInt(1, id);
            statement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

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
            String link = rs.getString("link");
            event.setLink(link);
            events.add(event);
        }

        return events;
    }


    public void update(Event event) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(
                    "UPDATE events SET eventName=?, description=?, eventDate=?, category_id=?, link=?" +
                            "WHERE id = ?");
            statement.setString(1, event.getName());
            statement.setString(2, event.getDescription());
            statement.setString(3, event.simpleStringFromDate());
            statement.setInt(4, event.getEventCategory().getId());
            statement.setString(5, event.getLink());
            statement.setInt(6, event.getId());

            statement.execute();

        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    public void update(int eventId, String ename, String description, String edate, int category) {
        try {
            PreparedStatement statement = this.getConnection().prepareStatement(
                    "UPDATE events SET eventName=?, description=?, eventDate=?, category_id=? " +
                            "WHERE id = ?");
            statement.setString(1, ename);
            statement.setString(2, description);
            statement.setString(3, edate);
            statement.setString(4, edate);
            statement.setInt(5, eventId);

            statement.execute();

        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }
}
