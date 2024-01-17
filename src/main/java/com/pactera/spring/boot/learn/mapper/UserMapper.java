package com.pactera.spring.boot.learn.mapper;

import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<UserVO> queryUserList(UserDTO requestDto);
    UserVO getUser(@Param("id") Long id);
    int addUser(UserDTO userDto);
    int updateUser(UserDTO userDto);
    int delUser(@Param("id") Long id);
}
