package com.pactera.spring.boot.learn.service.impl;

import com.pactera.spring.boot.learn.bean.dto.DoLoginDTO;
import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.entity.DoLoginEntity;
import com.pactera.spring.boot.learn.bean.vo.UserVO;
import com.pactera.spring.boot.learn.domain.UserData;
import com.pactera.spring.boot.learn.exception.ServiceException;
import com.pactera.spring.boot.learn.mapper.UserMapper;
import com.pactera.spring.boot.learn.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    public boolean doLogin(DoLoginDTO doLoginDto) {
        DoLoginEntity doLoginEntity = new DoLoginEntity("user1","Pswd123!@#");
        UserData userData = new UserData(doLoginEntity.getUsername(), doLoginEntity.getPassword());
        return userData.checkLogin(doLoginDto.getUsername(), doLoginDto.getPassword());
    }

    @Override
    public List<UserVO> queryUserList(UserDTO requestDto) {
        log.info("queryUserList:{}", requestDto);
        return userMapper.queryUserList(requestDto);
    }

    @Override
    @Cacheable("userCache")
    public UserVO getUser(Long id) {
        log.info("getUser:{}", id);
        return userMapper.getUser(id);
    }

    @Override
    public void addUser(UserDTO userDto) {
        log.info("addUser:{}", userDto);
        if("admin".equals(userDto.getName())) {
            throw new ServiceException("insertUser 抛出的自定义异常");
        }
        userMapper.addUser(userDto);
    }

    @Override
    @CacheEvict("userCache")
    public void updateUser(UserDTO userDto) {
        log.info("updateUser:{}", userDto);
        userMapper.updateUser(userDto);
    }

    @Override
    public void delUser(Long id) {
        log.info("delUser:{}", id);
        userMapper.delUser(id);
    }

}
