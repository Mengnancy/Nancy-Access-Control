package com.nancy.control.service.impl;

import com.nancy.control.bean.Menu;
import com.nancy.control.bean.UserInfo;
import com.nancy.control.dao.UserMapper;
import com.nancy.control.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/26 22:11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo findByUsername(String userName) {
        UserInfo userInfo = userMapper.findUser(userName);
        if(userInfo!=null){
            userInfo.setRoleList(userMapper.findRoleByUser(userInfo.getIdUser()));
            userInfo.getRoleList().stream().forEach(sysRole -> {
                List<Menu> permission = userMapper.findPermissionByRole(sysRole.getIdRole());
                sysRole.setPermissions(permission);
            });
        }
        return userInfo;
    }
}
