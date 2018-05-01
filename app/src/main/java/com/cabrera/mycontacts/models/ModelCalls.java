package com.cabrera.mycontacts.models;

public class ModelCalls {

    private String number, duration, date;

    public ModelCalls(String name, String duration, String date) {
        this.number = name;
        this.duration = duration;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String name) {
        this.number = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
