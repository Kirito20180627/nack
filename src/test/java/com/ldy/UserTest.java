package com.ldy;

import com.ldy.common.exception.UtilException;
import com.ldy.common.utils.token.JwtUtil;
import com.ldy.controller.user.UserController;
import com.ldy.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserController userController;

    @Test
    public void checkToken() throws UtilException {
        boolean qw =JwtUtil.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6ImxkeSIsImV4cCI6MTU2NzYwMjE1M30.h-OP3rAT1GPkgND3YNPE8b9iSzwbfEyDl6rrF47R-2M", "ldy");
        System.out.println(qw);
    }

    @Test
    public void tokenTest() {
        userController.all();
    }

    @Test
    public void SimpleJavaApp(){

    }
}
