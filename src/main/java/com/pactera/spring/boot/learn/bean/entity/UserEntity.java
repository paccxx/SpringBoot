package com.pactera.spring.boot.learn.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    /** 主键ID */
    private Long id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private int age;
    /** 邮箱 */
    private String email;
    /** 头像 */
    private String avatar;
}
