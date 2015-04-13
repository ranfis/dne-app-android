package com.eem.apps.enelmall.model;

public class Store {
    private int id;
    private String name;
    private double rating;
    private String hoursOpen;
    private String daysOpen;
    private Object image;
    private String urlFacebook;
    private String urlWebsite;
    private String phone;
    private String details;


    public Store(int id, String name,String hoursOpen,String daysOpen) {
        this.id = id;
        this.name = name;
        this.setHoursOpen(hoursOpen);
        this.setDaysOpen(daysOpen);
    }

    public Store(int id, String name, String hoursOpen, String daysOpen, Object image, String urlFacebook, String urlWebsite, String phone, String details) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.hoursOpen = hoursOpen;
        this.daysOpen = daysOpen;
        this.image = image;
        this.urlFacebook = urlFacebook;
        this.urlWebsite = urlWebsite;
        this.phone = phone;
        this.details = details;
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

    public String getDaysOpen() {
        return daysOpen;
    }

    public void setDaysOpen(String daysOpen) {
        this.daysOpen = daysOpen;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String urlFacebook) {
        this.urlFacebook = urlFacebook;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
