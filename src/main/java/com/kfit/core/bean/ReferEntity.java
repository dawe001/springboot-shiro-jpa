package com.kfit.core.bean;

import javax.persistence.MappedSuperclass;

/**
 * Created by davi on 2017/6/20.
 */
@MappedSuperclass
public class ReferEntity extends Staff{
    public ReferEntity(int sid, String sname) {
        super(sid, sname);
    }

    public ReferEntity() {
    }
}
