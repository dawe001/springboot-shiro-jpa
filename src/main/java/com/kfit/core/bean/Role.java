package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sj on 17/5/31.
 */
@Entity
@Table(name = "sys_role")
public class Role extends BaseEntity {

    private boolean available;

    @Column(nullable = false)
    private String name;

    private String remark;

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    @JsonIgnore
    @OneToMany(mappedBy="role", cascade=CascadeType.ALL)
//    @JoinColumn(name="role_id") // join column is in table for Order
//    @JoinTable(name = "sys_role_permission", joinColumns=@JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    @OneToMany(orphanRemoval=true)
//    @JoinColumn(name="role_id") // join column is in table for Order
    private List<RolePermission> rolePermissions;

    public Role() {}

    public Role(Long id, String name, String remark) {
        super(id);
        this.name = name;
        this.remark = remark;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
