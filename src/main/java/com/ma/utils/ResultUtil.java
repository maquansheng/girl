package com.ma.utils;

import com.ma.domain.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setData(object);
        result.setMsg("成功");
        return result;
    }

    public static Result success() {
        return null;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
