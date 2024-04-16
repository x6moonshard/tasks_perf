package org.example.model;

public class ValuesJSON {
    private int id;
    private String title;
    private String value;

    public ValuesJSON(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }
}
