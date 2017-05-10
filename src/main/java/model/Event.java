package model;


import java.util.Date;

public class Event {

    private String name;
    private String description;
    private Date eventDate;
    private EventCategory eventCategory;
    private Integer id;


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
}
