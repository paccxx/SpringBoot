package com.pactera.spring.boot.learn.exception;

import com.pactera.spring.boot.learn.bean.vo.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<R> handleServiceException(ServiceException ex) {
        ex.printStackTrace();
        // 在这里可以根据具体需求进行异常处理逻辑
        System.out.println("全局异常拦截器捕获");
        // 返回适当的HTTP状态码和错误信息
        return new ResponseEntity<>(R.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
