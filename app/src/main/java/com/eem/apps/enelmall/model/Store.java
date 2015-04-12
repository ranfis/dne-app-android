package com.eem.apps.enelmall.model;

public class Store {
    private int id;
    private String name;
    private double rating;
    private String hoursOpen;
    private String dayssOpen;

    public Store(int id, String name,String hoursOpen,String dayssOpen) {
        this.id = id;
        this.name = name;
        this.setHoursOpen(hoursOpen);
        this.setDayssOpen(dayssOpen);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(String hoursOpen) {
        this.hoursOpen = hoursOpen;
    }

    public String getDayssOpen() {
        return dayssOpen;
    }

    public void setDayssOpen(String dayssOpen) {
        this.dayssOpen = dayssOpen;
    }
}
