CREATE TABLE `auth` (
  `id_auth` varchar(32) NOT NULL COMMENT '权限ID',
  `id_menu` varchar(32) NOT NULL COMMENT '角色唯一ID',
  `id_role` varchar(32) NOT NULL COMMENT '菜单ID',
  `insert_date` datetime NOT NULL COMMENT '插入日期',
  PRIMARY KEY (`id_auth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `menu` (
  `id_menu` varchar(32) NOT NULL COMMENT '菜单唯一ID',
  `menu_name` varchar(30) NOT NULL COMMENT '菜单名称',
  `chinese_name` varchar(30) NOT NULL COMMENT '菜单中文名',
  `parent` varchar(32) DEFAULT NULL COMMENT '父菜单',
  `is_up` tinyint(4) DEFAULT NULL COMMENT '是否是顶层菜单',
  `url` varchar(100) DEFAULT NULL COMMENT 'url',
  `router` varchar(25) DEFAULT NULL COMMENT '前端路由',
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `production` (
  `id_production` varchar(32) NOT NULL DEFAULT '' COMMENT '作品唯一id',
  `product_name` varchar(50) NOT NULL COMMENT '作品名称',
  `product_author` varchar(50) DEFAULT NULL COMMENT '作者',
  `product_desc` varchar(200) DEFAULT NULL COMMENT '作品描述',
  `directory` varchar(200) DEFAULT NULL COMMENT '相对路径',
  PRIMARY KEY (`id_production`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id_role` varchar(32) NOT NULL COMMENT '角色唯一ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名',
  `chinese_name` varchar(20) NOT NULL COMMENT '角色中文名',
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id_user` varchar(32) NOT NULL COMMENT '用户唯一ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户姓名',
  `user_password` varchar(64) NOT NULL COMMENT '用户密码',
  `credentials_salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `insert_date` datetime NOT NULL COMMENT '插入日期',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `id_user_role` varchar(32) NOT NULL,
  `id_user` varchar(32) NOT NULL COMMENT '用户ID',
  `id_role` varchar(32) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id_user_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
