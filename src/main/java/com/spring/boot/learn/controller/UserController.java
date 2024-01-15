package com.spring.boot.learn.controller;

import com.spring.boot.learn.bean.dto.UserDto;
import com.spring.boot.learn.bean.vo.ResultVo;
import com.spring.boot.learn.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PutMapping(value = "addUser")
    public ResultVo addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @DeleteMapping(value = "delUser")
    public ResultVo delUser(String username) {
        return userService.delUser(username);
    }

}