package com.kfit.core.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by davi on 2017/6/25.
 */
@Entity
@Table(name = "Tb_user")
public class User {

    @Id
    @GeneratedValue()
    private Long id;

    private Address homeAddress;

    @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "billing_street"))
            , @AttributeOverride(name = "city.zipCode", column = @Column(name = "billing_zipCode", length = 5))
            , @AttributeOverride(name = "city.name", column = @Column(name = "billing_city", insertable = false, updatable = false))
    })
    private Address billAddress;
    @NotNull
    @Column(columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private ActionType actionType ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Address getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(Address homeAddress) {
//        this.homeAddress = homeAddress;
//    }
//
//    public Address getBillAddress() {
//        return billAddress;
//    }
//
//    public void setBillAddress(Address billAddress) {
//        this.billAddress = billAddress;
//    }

    protected enum ActionType {
        H, M, L
    }
}
