package com.eem.apps.enelmall.model;

import org.json.JSONObject;
import java.util.Map;


public class Offer {
    private String title;
    private String description;
    private Type type;
    private Category category;
    private int expirationDate;
    private Store store;
    private Map<String, Integer> location;

    public Offer(String title, String description, Type type, Category category, int expirationDate, Store store, Map<String, Integer> location) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.category = category;
        this.expirationDate = expirationDate;
        this.store = store;
        this.location = location;
    }

    public Offer(JSONObject jsonObj) {
        this.title = jsonObj.getString("title");
        this.description = jsonObj.getString("description");
        this.type = (Type)jsonObj.getInt("type");
        this.category = (Category)jsonObj.getInt("category");
        this.expirationDate = jsonObj.getString("expirationDate");
        this.store = jsonObj.getInt("store");

        JSONObject location = jsonObj.getJSONObject("location");
        int latitude = location.getInt("latitude");
        int longitude = location.getInt("longitude");
        this.location.put("latitude",latitude);
        this.location.put("longitude",longitude);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }
}
