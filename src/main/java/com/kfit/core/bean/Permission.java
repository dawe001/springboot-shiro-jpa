package com.kfit.core.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by sj on 17/5/27.
 */
@Entity
public class Permission extends BaseEntity implements Comparable<Permission> {

    public static String PLACEHOLDER = "#";

    private boolean available;

    @Column(nullable = false, unique = true)
    private String code;

    @Override
    public int compareTo(Permission o) {
        return 0;
    }
}
