package com.pactera.spring.boot.learn.service;

import com.pactera.spring.boot.learn.bean.dto.DoLoginDTO;
import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.vo.UserVO;

import java.util.List;

public interface IUserService {
    boolean doLogin(DoLoginDTO doLoginDto);
    List<UserVO> queryUserList(UserDTO requestDto);
    UserVO getUser(Long id);
    void addUser(UserDTO userDto);
    void updateUser(UserDTO userDto);
    void delUser(Long id);
}
