package com.eem.apps.enelmall.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Map;


public class Offer implements Serializable {
    protected static final String TAG = "[Offer]";
    private int id;
    private String title;
    private String details;
    private Type type;
    private Category category;
    private String expirationDate;
    private Store store;
    private Map<String, Integer> location;
    private Object image;


    public Offer(int id){
        this.id = id;
    }

    public Offer(int id, String title, String details, Type type, Category category, String expirationDate, Store store, Map<String, Integer> location, Object image) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.type = type;
        this.category = category;
        this.expirationDate = expirationDate;
        this.store = store;
        this.location = location;
        this.image = image;
    }

    public Offer(JSONObject jsonObj) {
        try {
            this.title = jsonObj.getString("title");
            this.details = jsonObj.getString("details");
            this.type = Type.getFromId((int)jsonObj.get("type"));
            this.category = Category.getFromId((int) jsonObj.get("category"));
            this.expirationDate = jsonObj.getString("expirationDate");
            this.store = new Store(jsonObj.getInt("store"),"");
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
        return details;
    }

    public void setDescription(String details) {
        this.details = details;
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

    public static String getTag() {
        return TAG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Map<String, Integer> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Integer> location) {
        this.location = location;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String toString(){
        Log.d(TAG, "getOffers()");
        //String json = String.format("{title:%d, desc:%d, type:%d, category:%d, expirationDate:%d}", title, details, type, category, expirationDate);
        String json = "{title:"+title+", desc:"+details+", type:"+type+", category:"+category+", expirationDate:"+expirationDate+"}";
        return json;
    }
}
