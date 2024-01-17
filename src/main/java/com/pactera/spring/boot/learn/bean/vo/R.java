package com.pactera.spring.boot.learn.bean.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> success(T data) {
        return new R<>(200, "操作成功", data);
    }

    public static R<Boolean> success() {
        return new R<Boolean>(200, "操作成功", true);
    }

    public static <T> R<T> success(String msg, T data) {
        return new R<T>(200, msg, data);
    }

    public static R<Boolean> error() {
        return new R<Boolean>(500, "操作失败", false);
    }

    public static R<Boolean> error(String msg) {
        return new R<Boolean>(500, msg, false);
    }

}
