INSERT INTO menu (id_menu, menu_name, chinese_name, parent, is_up)
    VALUES (replace(uuid(), "-", ""), "menuMange","菜单管理","f1c0f4ae9fd911e8bd05b06ebf8005a8",0),
      (replace(uuid(), "-", ""), "authManage","用户授权","f1c0f4ae9fd911e8bd05b06ebf8005a8",0),
      (replace(uuid(), "-", ""), "roleManage","角色管理","f1c0f4ae9fd911e8bd05b06ebf8005a8",0),
      (replace(uuid(), "-", ""), "userManage","用户管理","f1c0f4ae9fd911e8bd05b06ebf8005a8",0);