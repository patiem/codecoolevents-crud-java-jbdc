package model;


public class EventCategory {

    private String name;
    private String description;
    private Integer id;

    public EventCategory(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EventCategory{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
