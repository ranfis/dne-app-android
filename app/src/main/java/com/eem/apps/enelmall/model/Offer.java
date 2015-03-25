package com.eem.apps.enelmall.model;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Map;


public class Offer {
    private int id;
    private String title;
    private String description;
    private Type type;
    private Category category;
    private String expirationDate;
    private Store store;
    private Map<String, Integer> location;

    public Offer(int id){
        this.id = id;
    }

    public Offer(String title, String description, Type type, Category category, String expirationDate, Store store, Map<String, Integer> location) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.category = category;
        this.expirationDate = expirationDate;
        this.store = store;
        this.location = location;
    }

    public Offer(JSONObject jsonObj) {
        try {
            this.title = jsonObj.getString("title");
            this.description = jsonObj.getString("description");
            this.type = (Type)jsonObj.get("type");

            this.category = (Category) jsonObj.get("category");
            this.expirationDate = jsonObj.getString("expirationDate");
            this.store = new Store(jsonObj.getInt("store"));

            JSONObject location = jsonObj.getJSONObject("location");
            int latitude = location.getInt("latitude");
            int longitude = location.getInt("longitude");
            this.location.put("latitude", latitude);
            this.location.put("longitude", longitude);
        }
        catch (JSONException ex){
            System.err.println("Bad JSONObject");
        }
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String toString(){
        //String json = String.format("{title:%d, desc:%d, type:%d, category:%d, expirationDate:%d}", title, description, type, category, expirationDate);
        String json = "{title:"+title+", desc:"+description+", type:"+type+", category:"+category+", expirationDate:"+expirationDate+"}";
        return json;
    }
}
