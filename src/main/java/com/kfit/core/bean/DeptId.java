package com.kfit.core.bean;

import java.io.Serializable;

/**
 * Created by davi on 2017/7/30.
 */
public class DeptId implements Serializable {
    private Long number;
    private String country;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
