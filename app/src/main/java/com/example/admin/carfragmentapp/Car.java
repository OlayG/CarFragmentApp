package com.example.admin.carfragmentapp;

/**
 * Created by Admin on 8/11/2017.
 */

public class Car {

    String Model, Type, Year;

    public Car(String model, String type, String year) {
        Model = model;
        Type = type;
        Year = year;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
