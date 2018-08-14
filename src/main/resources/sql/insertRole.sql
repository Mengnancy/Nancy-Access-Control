INSERT INTO role (id_role,role_name,chinese_name)
VALUES (replace(uuid(), "-", ""), "viewer", "作品管理岗"),
  (replace(uuid(), "-", ""), "userManage", "用户管理岗"),
  (replace(uuid(), "-", ""), "admin", "超级用户");