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
    //    @NotNull//等效nullable=false columnDefine=varchar not null
    private String name;
    //    @Transient//暂态属性，不出现在表中
    private Double salary;
    //    @Formula("select sum(id) from employee")//派生属性，不出现在表中
    private String deg;

    @Column(name = "dep_id")
    private Integer departmentId;
//    @JsonIgnore
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="parent_id", insertable = false, updatable = false)
//    private Employee parent;

    @ManyToOne
//    @JoinColumn(name = "dep_id")
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

}