package com.nancy.control.bean;

import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/26 22:05
 */
public class Menu {
    private String idMenu;
    private String menuName;
    private String chineseName;
    private List<Menu> children;
    private String permissionUrl;
    private String router;

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }
}
