package com.kfit.core.bean;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by davi on 2017/7/30.
 */
@Embeddable
@Access(AccessType.FIELD)
public class ContactInfo {
    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "pri_num")
    private Phone priPhone;

    @ManyToMany
    @JoinTable()
    @MapKey(name = "type")
    private Map<String, Phone> phones;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPriPhone() {
        return priPhone;
    }

    public void setPriPhone(Phone priPhone) {
        this.priPhone = priPhone;
    }

    public Map<String, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }
}
