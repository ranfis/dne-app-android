package com.eem.apps.enelmall.model;

public class Store {
    private int id;
    private String name;
    private double rating;

    public Store(int id){
        this.id = id;
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
}
