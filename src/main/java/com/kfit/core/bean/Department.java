package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
    //    @Id
//    @TableGenerator(name = "dep_gen",table = "ID_GEN",pkColumnName = "GEN_NAME",valueColumnName = "GEN_VAL",allocationSize = 2,pkColumnValue = "dep_r")
//    @GeneratedValue(generator = "dep_gen",strategy = GenerationType.TABLE)
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
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


//    @ElementCollection
//    @Column(name = "imgSrc")
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "dep_id"))
//    @MapKeyColumn(name = "key1")
//    @CollectionId(columns = @Column(name = "id"), type = @Type(type = "long"), generator = "ID_GENERATOR")
//    private Map<String, String> imageSet = new HashMap<>();


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

//        @OneToOne(optional = false)
////    @JoinColumn(name = "employee_id")
//        @PrimaryKeyJoinColumn
//    private Employee employee;


//    @OneToMany(mappedBy = "department")
//    @MapKeyColumn(name = "cub")
//    private Map<String, Employee> employeeMap;

//    @ManyToMany
//    @JoinTable(name = "dep_emp",joinColumns = @JoinColumn(name = "dep_id"),inverseJoinColumns = @JoinColumn(name = "emp_id"))
//    @MapKeyColumn(name = "cub")
//    private Map<String, Employee> employeeMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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