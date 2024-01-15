package com.pactera.spring.boot.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    private String username;
    private String password;
    public boolean checkLogin(String username, String password){
        boolean flg = false;
        if(StringUtils.hasText(this.username) && StringUtils.hasText(username)
                && this.username.equals(username)){
            if(StringUtils.hasText(this.password) && StringUtils.hasText(password)
                    && this.password.equals(password)){
                flg = true;
            }
        }
        return flg;
    }
}
