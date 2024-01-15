package com.pactera.spring.boot.learn.controller;

import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.vo.ResultVO;
import com.pactera.spring.boot.learn.bean.vo.UserVO;
import com.pactera.spring.boot.learn.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @PostMapping(value = "queryUserList")
    public List<UserVO> queryUserList(UserDTO requestDto) {
        return userService.queryUserList(requestDto);
    }

    @GetMapping(value = "getUser")
    public UserVO getUser(Long id) {
        return userService.getUser(id);
    }

    @PutMapping(value = "addUser")
    public ResultVO addUser(@RequestBody UserDTO userDto) {
        return userService.addUser(userDto);
    }

    @PostMapping(value = "updateUser")
    public ResultVO updateUser(@RequestBody UserDTO userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping(value = "delUser")
    public ResultVO delUser(Long id) {
        return userService.delUser(id);
    }

}