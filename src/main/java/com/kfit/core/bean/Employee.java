package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double salary;
    private String deg;


//    @JsonIgnore
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="parent_id", insertable = false, updatable = false)
//    private Employee parent;

    @ManyToOne
    @JoinColumn(name = "dep_id", nullable = false)
    private Department department;

//    @ManyToMany(mappedBy = "employees")
//    private List<Department> departments;


    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}