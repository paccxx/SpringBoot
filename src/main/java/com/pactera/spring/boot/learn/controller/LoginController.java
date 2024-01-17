package com.pactera.spring.boot.learn.controller;

import com.pactera.spring.boot.learn.bean.dto.DoLoginDTO;
import com.pactera.spring.boot.learn.bean.vo.R;
import com.pactera.spring.boot.learn.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Resource
    private IUserService userService;

    @GetMapping(value = "login")
    public String toLoginPage() {
        return "login.html";
    }

    @ResponseBody
    @PostMapping(value = "doLogin")
    public R doLogin(@RequestBody DoLoginDTO doLoginDto) {
        boolean flg = userService.doLogin(doLoginDto);
        if(flg) {
            return R.success();
        } else {
            return R.error();
        }
    }

}