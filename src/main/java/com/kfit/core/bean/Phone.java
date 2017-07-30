package com.kfit.core.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by davi on 2017/7/30.
 */
@Entity
public class Phone {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    private String num;

    private String type;

//    @ManyToMany(mappedBy = "contactInfo.phones")
//    Set<Employee> employees;
//
//
//    @ManyToMany(mappedBy = "contactInfo.phones")
//    Set<Department> departments;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public Set<Department> getDepartments() {
//        return departments;
//    }
//
//    public void setDepartments(Set<Department> departments) {
//        this.departments = departments;
//    }
}
