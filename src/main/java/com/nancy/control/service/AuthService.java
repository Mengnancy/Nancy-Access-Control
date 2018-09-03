package com.nancy.control.service;

import com.nancy.control.bean.ResponseVO;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 17:28
 */
public interface AuthService {
    ResponseVO login(String name, String password);
    ResponseVO logout();
    ResponseVO signUp(String name, String password);
}
