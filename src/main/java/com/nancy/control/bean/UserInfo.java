package com.nancy.control.bean;

import java.util.Date;
import java.util.List;

public class UserInfo {
    private String idUser;

    private String userName;

    private String userPassword;

    private List<SysRole> roleList;

    private String credentialsSalt;


    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getCredentialsSalt() {
        return credentialsSalt;
    }

    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = credentialsSalt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "idUser='" + idUser + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roleList=" + roleList +
                ", credentialsSalt='" + credentialsSalt + '\'' +
                '}';
    }
}