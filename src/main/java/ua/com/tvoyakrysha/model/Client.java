package ua.com.tvoyakrysha.model;

public class Client {
    private String id;
    private String fullName;
    private String greating;

    public Client() {
    }

    public Client(String id, String fullName) {

        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGreating(String greating) {
        this.greating = greating;
    }
}
