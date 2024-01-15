package com.pactera.spring.boot.learn.mapper;

import com.pactera.spring.boot.learn.bean.dto.UserDTO;
import com.pactera.spring.boot.learn.bean.vo.ResultVO;
import com.pactera.spring.boot.learn.bean.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<UserVO> queryUserList(@Param("req") UserDTO requestDto);
    UserVO getUser(@Param("id") Long id);
    ResultVO addUser(UserDTO userDto);
    ResultVO updateUser(UserDTO userDto);
    ResultVO delUser(@Param("id") Long id);
}
