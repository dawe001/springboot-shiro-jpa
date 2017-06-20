package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;

    public BaseEntity() {
        super();
    }

    public BaseEntity(long id) {
        super();
        this.id = id;
    }

    public boolean isNew() {
        return this.id == 0;
    }

    /**
     * This is used for hack lazy loading proxy.
     * see {@linkhttp://stackoverflow.com/questions/7586991/jsf-jpa-hibernate-proxy-inheritance-issue}
     */
    public boolean isInstanceOf(Class<? extends BaseEntity> clazz) {
        return clazz.isInstance(this);
    }


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
