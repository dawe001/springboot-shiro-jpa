package com.kfit.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sj on 17/5/27.
 */
@Entity
@Table(name = "sys_permission")
public class Permission extends BaseEntity implements Comparable<Permission> {

    public static String PLACEHOLDER = "#";

    private boolean available;

    @Column(nullable = false, unique = true)
    private String code;

    private String icon;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer seq;

    private String url;

    @Column(name = "parent_id")
    private Long parentId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Permission parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @OrderBy("seq, id")
    private Set<Permission> submenus;

    private Model model;

    @Override
    public int compareTo(Permission o) {
        return 0;
    }
//
//    @Transient
//    private int mpId;


    public static enum Model {
        SYS, AGENT
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public Set<Permission> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(Set<Permission> submenus) {
        this.submenus = submenus;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (other instanceof Permission) {
            return super.equals(other);
        }
        return false;
    }
}
