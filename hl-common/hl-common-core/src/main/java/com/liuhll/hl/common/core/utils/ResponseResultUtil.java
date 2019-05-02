package com.liuhll.hl.common.core.utils;

import com.liuhll.hl.common.core.enums.ResultCode;
import com.liuhll.hl.common.core.vo.ResponseResult;

public class ResponseResultUtil {

    public static <T> ResponseResult<T> success(T data, String message){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(ResultCode.Ok);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static <T> ResponseResult<T> success(T data) {

        String message = ResultCode.Ok.toString();
        return success(data,message);
    }

    public static ResponseResult<String> error(ResultCode code,Exception ex){
        return error(code,ex.getMessage());
    }
    public static ResponseResult<String> error(ResultCode code,String errorMessage){
        ResponseResult<String> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(errorMessage);
        return result;
    }

    public static ResponseResult<Object> unValid(Object validError){
        ResponseResult<Object> result = new ResponseResult<>();
        result.setCode(ResultCode.UnValid);
        result.setValidError(validError);
        return result;
    }
}
