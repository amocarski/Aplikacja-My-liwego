package com.example.am.aplikacjamyliwego;

import android.graphics.drawable.Drawable;

public class DrawingPin {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private String type;
    private Drawable icon;

    DrawingPin() {
        this.id = -1;
        this.name = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.type = "";
        this.icon = null;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    //get
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getType() {
        return this.type;
    }

    public Drawable getIcon() {
        return this.icon;
    }

}
