package org.example.model;

import org.json.simple.JSONArray;

import java.util.List;

public class MainJSON {
    private int id;
    private String title;
    private String value;
    private JSONArray values;

    public MainJSON() {

    }
    public MainJSON(int id, String title, String value, JSONArray values) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
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

    public List<ValuesJSON> getValues() {
        return values;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValues(JSONArray values) {
        this.values = values;
    }
}
