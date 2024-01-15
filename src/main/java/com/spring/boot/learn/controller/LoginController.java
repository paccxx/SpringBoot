package com.spring.boot.learn.controller;

import com.spring.boot.learn.bean.dto.DoLoginDto;
import com.spring.boot.learn.bean.vo.ResultVo;
import com.spring.boot.learn.service.IUserService;
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
    public ResultVo doLogin(@RequestBody DoLoginDto doLoginDto) {
        return userService.doLogin(doLoginDto);
    }

}