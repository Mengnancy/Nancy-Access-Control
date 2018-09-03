package com.nancy.control.controller;

import com.nancy.control.bean.ResponseVO;
import com.nancy.control.service.AuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVO login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        return authService.login(username, password);
    }

    @RequestMapping(value = "/logout")
    public ResponseVO logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated() == true) {
            currentUser.logout();
        }
        return new ResponseVO("退出登录成功");
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseVO singUp(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        return authService.signUp(username, password);
    }
}
