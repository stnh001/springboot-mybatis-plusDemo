package com.mybatisplus.common;

/**
 * Created by luwan on 2018/9/26.
 */
public interface ErrorMessage {
    String INTERNAL_SERVER = "系统出现异常，请稍后重试。";

    String NAME_EXIST = "中文名称已存在";

    String CODE_EXIST = "code已存在";

    String PERMISSION_DENIED = "对不起,您没有删除权限~";
}
