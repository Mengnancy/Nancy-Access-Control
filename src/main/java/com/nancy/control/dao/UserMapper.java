package com.nancy.control.dao;

import com.nancy.control.bean.Menu;
import com.nancy.control.bean.SysRole;
import com.nancy.control.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;


@Repository
@Mapper
public interface UserMapper {
    UserInfo findUser(String userName);

    List<SysRole> findRoleByUser(String id);

    List<Menu> findPermissionByRole(String id);
}