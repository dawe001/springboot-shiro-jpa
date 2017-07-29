package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Id
//    @TableGenerator(name = "emp_gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 100)
//    @GeneratedValue(generator = "emp_gen", strategy = GenerationType.TABLE)
//    @Id
//    @GeneratedValue(generator = "ID1_GENERATOR")
//    @GenericGenerator(name = "ID1_GENERATOR", strategy = "uuid", parameters = {})

        private Long id;
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
//    @JoinTable(name = "emp_dep",joinColumns = @JoinColumn(name = "emp_id"),inverseJoinColumns = @JoinColumn(name = "dep_id"))
//    private Department department;

//    @OneToOne(mappedBy = "employee")
//    private Department department;

//    @ManyToMany(mappedBy = "employees")
//    private List<Department> departments;

//@ElementCollection
//@CollectionTable(name = "addr",joinColumns = @JoinColumn(name = "emp_id"))
//private Set<City> addressCollection;


//    @ElementCollection
//    @CollectionTable(name = "addr",joinColumns = @JoinColumn(name = "emp_id"))
//    @MapKeyColumn(name = "aaa")
//    private Map<String,City> addressCollection;

//    @ElementCollection
//    @CollectionTable(name = "addr", joinColumns = @JoinColumn(name = "emp_id"))
//    @AttributeOverrides({@AttributeOverride(name = "key.fileName", column = @Column(name = "file_name", insertable = false, updatable = false)),
//            @AttributeOverride(name = "key.extension", column = @Column(name = "ex_te", insertable = false, updatable = false))})
//    private Map<FileName, City> addressCollection;
//
//
//    @ElementCollection
//    @CollectionTable(name = "addrsss", joinColumns = @JoinColumn(name = "emp_id"))
//    @AttributeOverrides({@AttributeOverride(name = "key.fileName", column = @Column(name = "file_name", insertable = false, updatable = false)),
//            @AttributeOverride(name = "key.extension", column = @Column(name = "ex_te", insertable = false, updatable = false))})
//    private Map<FileName, User> addressCollection1;


//    public Collection<City> getAddressCollection() {
//        return addressCollection;
//    }
//
//    public void setAddressCollection(Collection<City> addressCollection) {
//        this.addressCollection = addressCollection;
//    }

    public Employee() {
        super();
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return com.google.common.base.Objects.equal(name, employee.name) &&
                com.google.common.base.Objects.equal(salary, employee.salary) &&
                com.google.common.base.Objects.equal(deg, employee.deg);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode( name, salary, deg);
    }
}