package com.liuhll.hl.common.vo;


import com.liuhll.hl.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private ResultCode code;

    private String message;

    private T Data;

    public ResponseResult(ResultCode code,T data){
        this.code = code;
        this.Data = data;
        this.message = code.toString();
    }
}
