package com.liuhll.hl.common.core.advice;

import com.liuhll.hl.common.core.enums.ResultCode;
import com.liuhll.hl.common.core.exception.UserFriendlyException;
import com.liuhll.hl.common.core.utils.ResponseResultUtil;
import com.liuhll.hl.common.core.vo.ResponseResult;
import com.liuhll.hl.common.core.exception.HlException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = HlException.class)
    public ResponseResult<String> handlerAdException(HttpServletRequest req,
                                                     HlException ex) {
        ResponseResult<String> response = ResponseResultUtil.error(ex.getCode(),ex);
        return response;
    }

    @ExceptionHandler(value = UserFriendlyException.class)
    public ResponseResult<String> handlerAdException(HttpServletRequest req,
                                                     UserFriendlyException ex) {
        ResponseResult<String> response = ResponseResultUtil.error(ex.getCode(),ex.getMessage());
        return response;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseResult<String> handlerAdException(HttpServletRequest req,
                                                     Exception ex) {
        ResponseResult<String> response = ResponseResultUtil.error(ResultCode.PlatformException,ex);
        return response;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<Object> handlerValidException(HttpServletRequest req,Exception ex){
        Dictionary<String,String> errors = new Hashtable<>();
        List<ObjectError> objectErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
        for (ObjectError error : objectErrors){

            errors.put(((FieldError) error).getField(),error.getDefaultMessage());
        }
        ResponseResult<Object>  response = ResponseResultUtil.unValid(errors);
        return response;

    }
}
