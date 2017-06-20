package com.kfit.core.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
//@DiscriminatorColumn
public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GenericGenerator(name = "sys-uuid",strategy = "uuid")
    private int sid;
    @Column(columnDefinition = "varchar(128) not null")
    private String sname;

    public Staff(int sid, String sname) {
        super();
        this.sid = sid;
        this.sname = sname;
    }

    public Staff() {
        super();
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}