package com.kfit.core.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by davi on 2017/6/25.
 */
@Embeddable
public class Address {
    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

//    @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "city", nullable = false,insertable = false))
//    })
//    private City city;
}
