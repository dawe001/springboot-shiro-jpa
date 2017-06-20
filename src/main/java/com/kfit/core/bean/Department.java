package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @OneToMany(mappedBy = "department")
//    @OneToMany
//    @JoinTable(name = "dep_em",joinColumns ={@JoinColumn(name = "id")},inverseJoinColumns = {@JoinColumn(name = "sid")})
//    @JoinColumn(name = "dep_id")

//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name="em_dep",
//            joinColumns = @JoinColumn(name = "id", columnDefinition = "int primary key"),
//            inverseJoinColumns = @JoinColumn( name = "objectproxy_id"),
//            uniqueConstraints = {@UniqueConstraint(columnNames={"id", "objectproxy_id"})}
//    )
//    @JoinTable(name = "em_dep",joinColumns = {@JoinColumn(name = "em_id")}, inverseJoinColumns = {@JoinColumn(name = "dep_id")})
//    private List<Employee> employees;


    //    @OneToOne(mappedBy = "department")
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Employee> getList() {
//        return list;
//    }
//
//    public void setList(List<Employee> list) {
//        this.list = list;
//    }

    public String getName() {
        return name;
    }

    public void setName(String deptName) {
        this.name = deptName;
    }
}