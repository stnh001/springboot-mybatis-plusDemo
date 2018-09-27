package com.mybatisplus.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by luwan on 2018/9/26.
 */
@Data
public class CallbackParam implements Serializable {
    private static final long serialVersionUID = 4064118805074330001L;
    private String callback;
    private String scriptWrapping;
}
