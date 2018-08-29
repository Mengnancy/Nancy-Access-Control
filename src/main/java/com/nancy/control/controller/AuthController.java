package com.nancy.control.controller;

import com.nancy.control.bean.ResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 15:56
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVO login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {

        String msg = "login";
        // 创建Subject实例
        Subject currentUser = SecurityUtils.getSubject();

        // 将用户名及密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            currentUser.login(token);
            // 判断当前用户是否登录
            if (currentUser.isAuthenticated() == true) {
                return new ResponseVO(msg);
            }
        } catch (Exception exception) {
            if (exception != null) {
                if (UnknownAccountException.class.getName().equals(exception)) {
                    System.out.println("UnknownAccountException -- > 账号不存在：");
                    msg = "UnknownAccountException -- > 账号不存在：";
                } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                    System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                    msg = "IncorrectCredentialsException -- > 密码不正确：";
                } else if ("kaptchaValidateFailed".equals(exception)) {
                    System.out.println("kaptchaValidateFailed -- > 验证码错误");
                    msg = "kaptchaValidateFailed -- > 验证码错误";
                } else {
                    msg = "else >> " + exception;
                    System.out.println("else -- >" + exception);
                }
            }
        }
        return new ResponseVO(0, msg);
    }

    @RequestMapping(value = "/logout")
    public ResponseVO logout() {

        return null;
    }
}
