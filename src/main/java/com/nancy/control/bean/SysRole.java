package com.nancy.control.bean;

import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/26 22:01
 */
public class SysRole {
    private String idRole;
    private String roleName;
    private List<Menu> permissions;

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Menu> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Menu> permissions) {
        this.permissions = permissions;
    }
}
