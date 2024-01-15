package com.spring.boot.learn.service.impl;

import com.spring.boot.learn.bean.dto.DoLoginDto;
import com.spring.boot.learn.bean.dto.UserDto;
import com.spring.boot.learn.bean.entity.UserEntity;
import com.spring.boot.learn.bean.vo.ResultVo;
import com.spring.boot.learn.domain.UserData;
import com.spring.boot.learn.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements IUserService {
    public ResultVo doLogin(DoLoginDto doLoginDto) {
        UserEntity userEntity = new UserEntity("user1","Pswd123!@#");
        UserData userData = new UserData(userEntity.getUsername(), userEntity.getPassword());
        boolean flg = userData.checkLogin(doLoginDto.getUsername(), doLoginDto.getPassword());
        return new ResultVo(flg);
    }

    @Override
    public ResultVo addUser(UserDto userDto) {
        log.info("addUser:{}", userDto);
        return new ResultVo(true);
    }

    @Override
    public ResultVo delUser(String username) {
        log.info("delUser:{}", username);
        return new ResultVo(true);
    }
}
