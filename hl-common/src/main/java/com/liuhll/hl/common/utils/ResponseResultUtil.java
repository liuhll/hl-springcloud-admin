package com.liuhll.hl.common.utils;

import com.liuhll.hl.common.enums.ResultCode;
import com.liuhll.hl.common.vo.ResponseResult;

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

    public static <T> ResponseResult<T> error(ResultCode code,Exception ex){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(ex.getMessage());
        return result;
    }
    public static <T> ResponseResult<T> error(ResultCode code,String errorMessage){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(errorMessage);
        return result;
    }
}
