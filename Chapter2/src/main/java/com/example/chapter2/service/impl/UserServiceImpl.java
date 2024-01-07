package com.example.chapter2.service.impl;

import com.example.chapter2.bean.dto.DoLoginDto;
import com.example.chapter2.bean.dto.UserDto;
import com.example.chapter2.bean.entity.UserEntity;
import com.example.chapter2.bean.vo.ResultVo;
import com.example.chapter2.domain.UserData;
import com.example.chapter2.service.IUserService;
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
