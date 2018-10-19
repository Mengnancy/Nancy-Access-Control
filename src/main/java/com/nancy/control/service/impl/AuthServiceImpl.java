package com.nancy.control.service.impl;

import com.nancy.control.bean.ResponseVO;
import com.nancy.control.bean.UserInfo;
import com.nancy.control.dao.UserMapper;
import com.nancy.control.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 17:27
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    SecureRandomNumberGenerator secureRandomNumberGenerator;

    @Override
    public ResponseVO login(String name, String password) {

        String msg = "login";
        // 创建Subject实例
        Subject currentUser = SecurityUtils.getSubject();

        /**
         * 将用户名及密码封装到UsernamePasswordToken
         * 如果有用户信息类也可以继承这个类实现自己的方法
         */
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            currentUser.login(token);
            // 判断当前用户是否登录
            if (currentUser.isAuthenticated() == true) {
                return new ResponseVO(msg);
            }
        } catch (Exception exception) {
            if (exception != null) {
                if (UnknownAccountException.class.getName().equals(exception) ||
                        IncorrectCredentialsException.class.getName().equals(exception)) {
                    System.out.println("UnknownAccountException -- > 账号或密码错误：");
                    msg = "UnknownAccountException -- > 账号或密码错误：";
                } else {
                    msg = "else >> " + exception;
                    System.out.println("else -- >" + exception);
                }
            }
        }
        return new ResponseVO(0, msg);
    }

    @Override
    public ResponseVO logout() {
        return null;
    }

    @Override
    public ResponseVO signUp(String name, String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(name);
        userInfo.setCredentialsSalt(secureRandomNumberGenerator.nextBytes().toString());
        String credential = new SimpleHash("md5", password, ByteSource.Util.bytes(userInfo.getCredentialsSalt()), 2).toString();
        userInfo.setUserPassword(credential);
        if (userMapper.findUser(name) != null) {
            return new ResponseVO(-1, "用户名已存在");
        }

        if (userMapper.insertUser(userInfo) > 0) {
            return new ResponseVO("注册成功");
        }
        return new ResponseVO(-1, "注册失败");
    }

}
