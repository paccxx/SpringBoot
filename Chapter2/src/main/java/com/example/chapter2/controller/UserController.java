package com.example.chapter2.controller;

import com.example.chapter2.bean.dto.UserDto;
import com.example.chapter2.bean.vo.ResultVo;
import com.example.chapter2.service.IUserService;
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