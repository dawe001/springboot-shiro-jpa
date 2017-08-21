package com.kfit.core.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by davi on 2017/7/30.
 */
//@Entity
@IdClass(ProjectId.class)
public class Project implements Serializable {
    @Id
    private String name;
    @Id
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "dep_num",referencedColumnName = "number"),
            @JoinColumn(name = "dep_country",referencedColumnName = "country")
    })
    private Department dept;
}
