package dao;

import model.Event;
import model.EventCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pati on 10.05.17.
 */
public class EventCategoryDao {

    public void add(EventCategory eventCategory) {
    }


    public EventCategory find(int id) {
        EventCategory eventCategory = null;
        return eventCategory;
    }

    public void remove(int id) {

    }

    public List<EventCategory> getAll() {

        List<EventCategory> eventCategories = new ArrayList<EventCategory>();
        return eventCategories;
    }


}
