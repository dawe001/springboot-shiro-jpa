package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Optional;

@Entity
//@IdClass(EmployeeId.class)
//@SecondaryTable(name = "emp_info",pkJoinColumns = @PrimaryKeyJoinColumn(name = "emp_id"))
public class Employee implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//        @Id
//    @TableGenerator(name = "emp_gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 100)
//    @GeneratedValue(generator = "emp_gen", strategy = GenerationType.TABLE)
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
//    @GenericGenerator(name = "ID1_GENERATOR", strategy = "uuid", parameters = {})

//    @Id
    private Long id;
//
//    @Id
//    @Column(name = "emp_id")
//    private String country;

//    @EmbeddedId
//    private EmployeeId_ id;


    //    @NotNull//等效nullable=false columnDefine=varchar not null
    private String name;
    //    @Transient//暂态属性，不出现在表中
    private Double salary;
    //    @Formula("select sum(id) from employee")//派生属性，不出现在表中
//    @Column(table = "emp_info")
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

//    @Enumerated(value = EnumType.STRING)
//    private Sex sex;

//    private ContactInfo contactInfo;
//
//    public ContactInfo getContactInfo() {
//        return contactInfo;
//    }
//
//    public void setContactInfo(ContactInfo contactInfo) {
//        this.contactInfo = contactInfo;
//    }

    //    public Collection<City> getAddressCollection() {
//        return addressCollection;
//    }
//
//    public void setAddressCollection(Collection<City> addressCollection) {
//        this.addressCollection = addressCollection;
//    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//    public Sex getSex() {
//        return sex;
//    }
//
//    public void setSex(Sex sex) {
//        this.sex = sex;
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
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", deg='").append(deg).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return Objects.equal(id, employee.id) &&
//                Objects.equal(name, employee.name) &&
//                Objects.equal(salary, employee.salary) &&
//                Objects.equal(deg, employee.deg);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id, name, salary, deg);
//    }

    public static enum Sex {
        MAN("男"), WOMEN;
        private String value;

        public String getValue() {
            return value;
        }

        Sex() {
        }

        Sex(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }


    }

//    public EmployeeId_ getId() {
//        return id;
//    }
//
//    public void setId(EmployeeId_ id) {
//        this.id = id;
//    }

    public static void main(String[] args) {
        System.out.println(Sex.MAN.getValue());
    }
}