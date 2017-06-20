package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/16.
 */
import javax.persistence.*;

/**
 * Created by sj on 17/5/31.
 */
@Entity
@Table(name = "sys_role_permission")
public class RolePermission extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="permission_id", nullable=false, updatable=false)
    private Permission permission;

    public int getOperate() {
        return operate;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }

    private int operate;

    public static enum Curd {
        VIEW(1), UPDATE(2), DELETE(3), EXPORT(4);

        private int value;

        Curd(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

//    public Curd getOperate() {
//        return operate;
//    }
//
//    public void setOperate(Curd operate) {
//        this.operate = operate;
//    }
}

