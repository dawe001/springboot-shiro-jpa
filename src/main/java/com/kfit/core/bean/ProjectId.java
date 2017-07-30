package com.kfit.core.bean;

import java.io.Serializable;

/**
 * Created by davi on 2017/7/30.
 */
public class ProjectId implements Serializable {
    private String name;
    private DeptId dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeptId getDept() {
        return dept;
    }

    public void setDept(DeptId dept) {
        this.dept = dept;
    }
}
