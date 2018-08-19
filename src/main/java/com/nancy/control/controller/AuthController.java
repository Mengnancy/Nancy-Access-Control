package com.nancy.control.controller;

import com.nancy.control.bean.ResponseVO;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 15:56
 */
@RestController("/auth")
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVO login(@RequestParam("name") String name, @RequestParam("password") String password, HttpRequest request) {

        return null;
    }

    @RequestMapping(value = "logout")
    public ResponseVO logout() {

        return null;
    }
}
