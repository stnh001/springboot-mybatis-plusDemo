package com.mybatisplus.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回给页面的对象。<br />
 * Created by luwan on 2018/9/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -6629012691534400264L;
    private Boolean success;
    private T data;
    private String msg;

    public static <T> ApiResult getSuccess(T data) {
        return new ApiResult(true, data, null);

    }

    public static ApiResult getFailed(String msg) {
        return new ApiResult(false, null, msg);
    }
}
