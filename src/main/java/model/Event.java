package model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    private String name;
    private String description;
    private Date eventDate;
    private EventCategory eventCategory;
    private Integer id;
    private String link = null;

    public Event(String name, String description, Date eventDate, EventCategory eventCategory,
                 Integer id) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.eventCategory = eventCategory;
        this.id = id;
    }

    public Event(String name, String description, String eventDate, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.eventDate = makeDateFromString(eventDate);
        this.eventCategory = eventCategory;
    }

    public Event(String name, String description, Date eventDate, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.eventCategory = eventCategory;
    }


    public static Date makeDateFromString(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date makeDateFromForm(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String simpleStringFromDate() {
        SimpleDateFormat formatter = new SimpleDateFormat( "dd-MM-yyyy");
        return formatter.format(this.getEventDate());
    }

    public String simpleStringDate() {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        return formatter.format(this.getEventDate());
    }

    public Boolean isEventAvailable() {
        Date today = new Date();
        if (today.before(this.getEventDate())) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasLink() {
        if (this.getLink() == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String eventName) {
        this.name = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer eventId) {
        this.id = eventId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eventDate=" + eventDate +
                ", eventCategory=" + eventCategory +
                ", id=" + id +
                '}';
    }
}
