package com.kfit.core.bean;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by davi on 2017/7/30.
 */
@Entity
public class Phone {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    private String type;


//    @ManyToMany(mappedBy = "contactInfo.phones")
//    Set<Employee> employees;
//
//
//    @ManyToMany(mappedBy = "contactInfo.phones")
//    Set<Department> departments;

    @Column(name = "created2")
    private Instant createTime2;


    @Column(name = "created1")
    private LocalDate createTime1;

    @Column(name = "created")
    private LocalDateTime createTime;

    @ManyToOne
    private Employee employee;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Optional<Employee> getEmployee() {
        return Optional.ofNullable(employee);
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getNum() {
//        return num;
//    }
//
//    public void setNum(String num) {
//        this.num = num;
//    }

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("id=").append(id);
        sb.append(", type='").append(type).append('\'');
        sb.append(", createTime2=").append(createTime2);
        sb.append(", createTime1=").append(createTime1);
        sb.append(", createTime=").append(createTime);
        sb.append(", employee=").append(employee);
        sb.append('}');
        return sb.toString();
    }
}
