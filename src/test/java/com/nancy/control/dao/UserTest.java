package com.nancy.control.dao;

import com.nancy.control.bean.UserInfo;
import com.nancy.control.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/26 23:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void findUserTest() {
        UserInfo info = userInfoService.findByUsername("admin");

        System.out.println(info);
    }

}
