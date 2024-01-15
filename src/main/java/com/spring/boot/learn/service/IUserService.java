package com.spring.boot.learn.service;

import com.spring.boot.learn.bean.dto.DoLoginDto;
import com.spring.boot.learn.bean.dto.UserDto;
import com.spring.boot.learn.bean.vo.ResultVo;

public interface IUserService {
    ResultVo doLogin(DoLoginDto doLoginDto);
    ResultVo addUser(UserDto userDto);
    ResultVo delUser(String username);
}
