package com.pactera.spring.boot.learn.controller;

import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.vo.R;
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
    public R<List<UserVO>> queryUserList(@RequestBody UserDTO requestDto) {
        return R.success(userService.queryUserList(requestDto));
    }

    @GetMapping(value = "getUser")
    public R<UserVO> getUser(Long id) {
        return R.success(userService.getUser(id));
    }

    @PutMapping(value = "addUser")
    public R addUser(@RequestBody UserDTO userDto) {
        userService.addUser(userDto);
        return R.success();
    }

    @PostMapping(value = "updateUser")
    public R updateUser(@RequestBody UserDTO userDto) {
        userService.updateUser(userDto);
        return R.success();
    }

    @DeleteMapping(value = "delUser")
    public R delUser(Long id) {
        userService.delUser(id);
        return R.success();
    }

}