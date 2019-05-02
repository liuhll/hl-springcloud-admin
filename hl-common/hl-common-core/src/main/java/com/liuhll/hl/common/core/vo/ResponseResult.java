package com.liuhll.hl.common.core.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.liuhll.hl.common.core.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    @JsonProperty
    private ResultCode code;

    @JsonProperty
    private String message;

    @JsonProperty
    private T data;

    @JsonProperty
    private T validError;

    public ResponseResult(ResultCode code,T data){
        this.code = code;
        this.data = data;
        this.message = code.toString();
    }

}
