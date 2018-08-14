INSERT INTO user (id_user, user_name, user_password, insert_date)
VALUES (replace(uuid(), "-", ""), "lingxin", "123", now()),
  (replace(uuid(), "-", ""), "guanli", "123", now()),
  (replace(uuid(), "-", ""), "admin", "123", now());

