package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
//@IdClass(DeptId.class)
public class Department {
    //    @Id
//    @TableGenerator(name = "dep_gen",table = "ID_GEN",pkColumnName = "GEN_NAME",valueColumnName = "GEN_VAL",allocationSize = 2,pkColumnValue = "dep_r")
//    @GeneratedValue(generator = "dep_gen",strategy = GenerationType.TABLE)
//    @Id
//    @GeneratedValue(generator = "ID_GENERATOR")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Id
    private Long number;

    private Boolean isLast;
//    @Id
    private String country;

    private String name;
//        @OneToMany(mappedBy = "department")
//    @JoinColumn(name = "dep_id")

    //    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name="em_dep",
//            joinColumns = @JoinColumn(name = "id", columnDefinition = "int primary key"),
//            inverseJoinColumns = @JoinColumn( name = "objectproxy_id"),
//            uniqueConstraints = {@UniqueConstraint(columnNames={"id", "objectproxy_id"})}
//    )
//    @JoinTable(name = "em_dep",joinColumns = {@JoinColumn(name = "em_id")}, inverseJoinColumns = {@JoinColumn(name = "dep_id")})


    @ElementCollection
    @Column(name = "imgSrc")
    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "dep_id"))
    @MapKeyColumn(name = "key1")
//    @CollectionId(columns = @Column(name = "id"), type = @Type(type = "long"), generator = "ID_GENERATOR")
    private Map<String, String> imageSet = new HashMap<>();


//    @ElementCollection
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "dep_id"))
//    @Column(name = "imgSrc")
//    @OrderColumn(name = "ord")
//    private List<String> list;


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "dep_em", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "sid")})
//    private List<Employee> employees;

//    @Transient
//    public String getSname() {
//        return employees.toString();
//    }

//    @OneToOne(optional = false)
////    @JoinColumn(name = "employee_id")
//    @PrimaryKeyJoinColumn
//    private Employee employee;


//    @OneToMany(mappedBy = "department")
//    @MapKeyColumn(name = "cub")
//    private Map<String, Employee> employeeMap;

//    @ManyToMany
//    @JoinTable(name = "dep_emp",joinColumns = @JoinColumn(name = "dep_id"),inverseJoinColumns = @JoinColumn(name = "emp_id"))
//    @MapKeyColumn(name = "cub")
//    private Map<String, Employee> employeeMap;


//    @OneToMany(mappedBy = "department")
//    @MapKey(name = "name")
//    private Map<Integer, Employee> employeeMap;

//    @AssociationOverrides({@AssociationOverride(name = "priPhone", joinColumns = @JoinColumn(name = "dep_phone")),
//            @AssociationOverride(name = "phones", joinTable = @JoinTable(name = "dep_phones"))})
//    private ContactInfo contactInfo;

//    public ContactInfo getContactInfo() {
//        return contactInfo;
//    }
//
//    public void setContactInfo(ContactInfo contactInfo) {
//        this.contactInfo = contactInfo;
//    }

    //    public Map<Integer, Employee> getEmployeeMap() {
//        return employeeMap;
//    }
//
//    public void setEmployeeMap(Map<Integer, Employee> employeeMap) {
//        this.employeeMap = employeeMap;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


//    public List<Employee> getList() {
//        return list;
//    }
//
//    public void setList(List<Employee> list) {
//        this.list = list;
//    }


//    public Map<String, String> getImageSet() {
//        return imageSet;
//    }
//
//    public void setImageSet(Map<String, String> imageSet) {
//        this.imageSet = imageSet;
//    }

    public String getName() {
        return name;
    }

    public void setName(String deptName) {
        this.name = deptName;
    }
}