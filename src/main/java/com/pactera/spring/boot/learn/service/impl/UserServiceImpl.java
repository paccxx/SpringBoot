package com.pactera.spring.boot.learn.service.impl;

import com.pactera.spring.boot.learn.bean.dto.DoLoginDTO;
import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.entity.DoLoginEntity;
import com.pactera.spring.boot.learn.bean.vo.ResultVO;
import com.pactera.spring.boot.learn.bean.vo.UserVO;
import com.pactera.spring.boot.learn.domain.UserData;
import com.pactera.spring.boot.learn.mapper.UserMapper;
import com.pactera.spring.boot.learn.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    public ResultVO doLogin(DoLoginDTO doLoginDto) {
        DoLoginEntity doLoginEntity = new DoLoginEntity("user1","Pswd123!@#");
        UserData userData = new UserData(doLoginEntity.getUsername(), doLoginEntity.getPassword());
        boolean flg = userData.checkLogin(doLoginDto.getUsername(), doLoginDto.getPassword());
        return new ResultVO(flg);
    }

    @Override
    public List<UserVO> queryUserList(UserDTO requestDto) {
        log.info("queryUserList:{}", requestDto);
        return userMapper.queryUserList(requestDto);
    }

    @Override
    public UserVO getUser(Long id) {
        log.info("getUser:{}", id);
        return userMapper.getUser(id);
    }

    @Override
    public ResultVO addUser(UserDTO userDto) {
        log.info("addUser:{}", userDto);
        userMapper.addUser(userDto);
        return new ResultVO(true);
    }

    @Override
    public ResultVO updateUser(UserDTO userDto) {
        log.info("updateUser:{}", userDto);
        userMapper.updateUser(userDto);
        return new ResultVO(true);
    }

    @Override
    public ResultVO delUser(Long id) {
        log.info("delUser:{}", id);
        userMapper.delUser(id);
        return new ResultVO(true);
    }

}
