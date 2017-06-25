package com.kfit.core.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by davi on 2017/6/25.
 */
@Embeddable
public class City {

    @Column(nullable = false, length = 5,insertable=false ,updatable=false)
    private String zipCode;

    @Column(nullable = false,insertable=false ,updatable=false)
    private String name;

    @Column(nullable = false,insertable=false ,updatable=false)
    private String country;
}
