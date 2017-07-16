package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
    //    @Id
//    @TableGenerator(name = "emp_gen",table = "ID_GEN",pkColumnName = "GEN_NAME",valueColumnName = "GEN_VAL",allocationSize = 100)
//    @GeneratedValue(generator = "emp_gen",strategy = GenerationType.TABLE)
    @Id
    @GeneratedValue(generator = "ID1_GENERATOR")
    @GenericGenerator(name = "ID1_GENERATOR", strategy = "uuid",parameters = {})
    private String id;
    //    @NotNull//等效nullable=false columnDefine=varchar not null
    private String name;
    //    @Transient//暂态属性，不出现在表中
    private Double salary;
    //    @Formula("select sum(id) from employee")//派生属性，不出现在表中
    private String deg;

//    @JsonIgnore
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="parent_id", insertable = false, updatable = false)
//    private Employee parent;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "dep_id")
//    private Department department;

//    @ManyToMany(mappedBy = "employees")
//    private List<Department> departments;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee() {
        super();
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