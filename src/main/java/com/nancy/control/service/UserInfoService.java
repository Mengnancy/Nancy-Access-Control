package com.nancy.control.service;

import com.nancy.control.bean.UserInfo;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/26 22:10
 */
public interface UserInfoService {
    UserInfo findByUsername(String userName);
}
