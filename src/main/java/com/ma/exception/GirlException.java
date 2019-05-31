package com.ma.exception;

import com.ma.enums.ResultEnum2;

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum2 resultEnum2) {
        super(resultEnum2.getMsg());
        this.code = resultEnum2.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
