package com.liuhll.hl.advice;

import com.liuhll.hl.enums.ResultCode;
import com.liuhll.hl.exception.HlException;
import com.liuhll.hl.utils.ResponseResultUtil;
import com.liuhll.hl.vo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = HlException.class)
    public ResponseResult<String> handlerAdException(HttpServletRequest req,
                                                     HlException ex) {
        ResponseResult<String> response = ResponseResultUtil.error(ex.getCode(),ex);
        return response;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseResult<String> handlerAdException(HttpServletRequest req,
                                                     Exception ex) {
        ResponseResult<String> response = ResponseResultUtil.error(ResultCode.PlatformException,ex);
        return response;
    }
}