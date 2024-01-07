package com.example.chapter2.service;

import com.example.chapter2.bean.dto.DoLoginDto;
import com.example.chapter2.bean.dto.UserDto;
import com.example.chapter2.bean.vo.ResultVo;

public interface IUserService {
    ResultVo doLogin(DoLoginDto doLoginDto);
    ResultVo addUser(UserDto userDto);
    ResultVo delUser(String username);
}
