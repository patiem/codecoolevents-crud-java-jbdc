package dao;

import model.EventCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {
            Statement statement = SqliteJDBCConnector.connection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE id = " + Integer.toString(id));

            if (rs.next()) {
                eventCategory = new EventCategory(
                        rs.getString("cname"),
                        rs.getString("description"),
                        rs.getInt("id")
                        );
            }

            rs.close();
        }catch (SQLException e) {
            System.out.println();System.out.println("Connect to DB failed");
            System.out.println(e.getMessage());
        }


        return eventCategory;
    }

    public void remove(int id) {

    }

    public List<EventCategory> getAll() {

        List<EventCategory> eventCategories = new ArrayList<EventCategory>();
        return eventCategories;
    }


    public EventCategory getByName(String categoryName) {
        EventCategory eventCategory = null;

        try {
            Statement statement = SqliteJDBCConnector.connection().createStatement();
            System.out.println(categoryName);

            ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE cname = '" + categoryName + "'");
            if (rs.next()) {
                eventCategory = new EventCategory(
                        rs.getString("cname"),
                        rs.getString("description"),
                        rs.getInt("id")
                );
            }

            rs.close();
        }catch (SQLException e) {
            System.out.println();System.out.println("Connect to DB failed");
            System.out.println(e.getMessage());
        }
        return eventCategory;
    }
}
