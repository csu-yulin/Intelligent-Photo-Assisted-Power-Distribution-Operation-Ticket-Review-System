package csu.yulin.ipas.handler;

import csu.yulin.ipas.common.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lp
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. 通用异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult<String> handleException(Exception e) {
        return ResponseResult.error(500, "服务器内部错误: " + e.getMessage());
    }
}