package com.pactera.spring.boot.learn.service;

import com.pactera.spring.boot.learn.bean.dto.DoLoginDTO;
import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.vo.ResultVO;
import com.pactera.spring.boot.learn.bean.vo.UserVO;

import java.util.List;

public interface IUserService {
    ResultVO doLogin(DoLoginDTO doLoginDto);
    List<UserVO> queryUserList(UserDTO requestDto);
    UserVO getUser(Long id);
    ResultVO addUser(UserDTO userDto);
    ResultVO updateUser(UserDTO userDto);
    ResultVO delUser(Long id);
}
