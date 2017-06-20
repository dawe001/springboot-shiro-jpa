package com.kfit.config.shiro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by davi on 2017/6/16.
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity exceptionHandle() {
        System.out.println("异常处理！！！");
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
