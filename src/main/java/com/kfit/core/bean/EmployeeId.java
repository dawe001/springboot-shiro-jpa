package com.kfit.core.bean;

import java.io.Serializable;

/**
 * Created by davi on 2017/7/30.
 */
public class EmployeeId implements Serializable{
    private int id;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
