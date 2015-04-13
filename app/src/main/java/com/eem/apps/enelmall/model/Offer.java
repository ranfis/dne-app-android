package com.eem.apps.enelmall.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Offer  {
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
    private Object fImageDetails;

    public Offer(int id, String title, String details, Type type, Category category, String expirationDate, Store store, Map<String, Integer> location, Object image) {
        Log.d(TAG,"Offer()");
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
        Log.d(TAG,"Offer()");
        try {
            JSONObject store = jsonObj.getJSONObject("store");
            this.title = jsonObj.getString("title");
            this.details = jsonObj.getString("details");
            this.type = Type.getFromId((int) jsonObj.get("type"));
            this.category = Category.getFromId((int) jsonObj.get("category"));
            this.expirationDate = jsonObj.getString("expirationDate");
            this.store = new Store(0,store.getString("name"),store.getString("hoursOpen"),store.getString("daysOpen"));
            this.image = jsonObj.getString("image");
        }
        catch (JSONException ex){
            Log.e(TAG,"Offer(): Bad JSONObject");
        }

        catch (IndexOutOfBoundsException ex){
            Log.e(TAG, "Offer(): Bad type or category");
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

    public Object getfImageDetails() {
        return fImageDetails;
    }

    public void setfImageDetails(Object fImageDetails) {
        this.fImageDetails = fImageDetails;
    }

    public String toString(){
        Log.d(TAG, "toString()");
        //String json = String.format("{title:%d, desc:%d, type:%d, category:%d, expirationDate:%d}", title, details, type, category, expirationDate);
        String json = "{\"id\":"+this.id+","
                +"\"title\":\""+this.title+"\","
                +"\"details\":\""+this.details+"\","
                +"\"type\":"+this.type.getId()+","
                +"\"category\":"+this.category.getId()+","
                +"\"expirationDate\":\""+this.expirationDate+"\","
                +"\"store\":{"
                    +"\"name\":\""+this.store.getName()+"\","
                    +"\"daysOpen\":\""+this.store.getDaysOpen()+"\","
                    +"\"hoursOpen\":\""+this.store.getHoursOpen()+"\""
                +"},"
                +"\"image\":\""+this.image+"\"}";
        return json;
    }


}
