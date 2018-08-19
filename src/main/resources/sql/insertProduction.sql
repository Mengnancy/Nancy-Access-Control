insert INTO production (id_production,product_name,product_author,product_desc)
    VALUES (replace(uuid(), "-", ""),'中国图书','lily','中国图书项目相关作品'),
      (replace(uuid(), "-", ""),'东方建设集团','nancy','东方建设集团项目相关作品'),
      (replace(uuid(), "-", ""),'前进一号','ming','前进一号项目相关作品'),
      (replace(uuid(), "-", ""),'美味厨房','南方中国','美味厨房项目相关作品');