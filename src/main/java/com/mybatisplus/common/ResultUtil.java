package com.mybatisplus.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 返回结果构造类
 *
 * Created by luwan on 2018/9/26.
 */
public class ResultUtil {

    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 根据请求参数和响应结果构造 {@link ApiResult}
     * @param data  返回的结果
     * @param param 提交的请求参数
     * @return
     */
    public static Object getSuccessResult(Object data, CallbackParam param) {
        // 返回JSONP格式
        if(param != null && StringUtils.isNotBlank(param.getCallback())) {
            //MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(data);
            //mappingJacksonValue.setJsonpFunction(param.getCallback());
            //return mappingJacksonValue;
            return returnJSONPString(param, returnJSONString(ApiResult.getSuccess(data), null));
        }
        return returnJSONString(ApiResult.getSuccess(data), null);
    }

    /**
     * 根据请求参数和响应结果构造 {@link ApiResult}
     * @param data  返回的结果
     * @param param 提交的请求参数
     * @param format 指定日期格式化方式
     * @return
     */
    public static Object getSuccessResultWithDateFormat(Object data, CallbackParam param, String format) {
        // 返回JSONP格式
        if(param != null && StringUtils.isNotBlank(param.getCallback())) {
            return returnJSONPString(param, returnJSONString(ApiResult.getSuccess(data), format));
        }
        return returnJSONString(ApiResult.getSuccess(data), format);
    }

    private static String returnJSONString(ApiResult result, String format) {
        if (StringUtils.isBlank(format)) {
            return JSON.toJSONStringWithDateFormat(result, YYYY_MM_DD_HH_MM_SS, SerializerFeature.WriteDateUseDateFormat);
        }
        else{
            return JSON.toJSONStringWithDateFormat(result, format, SerializerFeature.WriteDateUseDateFormat);
        }

    }

    private static Object returnJSONPString(CallbackParam param, String jsonString) {
        StringBuilder sb = new StringBuilder(64);
        if(param != null && StringUtils.isNotBlank(param.getScriptWrapping())) {
            sb.append("<script>");
            if(StringUtils.isNotBlank(param.getCallback())) {
                sb.append(param.getCallback()).append("(").append(jsonString).append(")");
            } else {
                sb.append(jsonString);
            }
            sb.append("</script>");
            return sb.toString();
        }
        if(param != null && StringUtils.isNotBlank(param.getCallback())) {
            sb.append(param.getCallback()).append("(").append(jsonString).append(")");
            return sb.toString();
        }
        return sb;
    }

    /**
     * 根据请求参数和响应结果构造 {@link ApiResult}
     * @param msg   错误描述
     * @param param 提交的请求参数
     * @return
     */
    public static Object getFailedResult(String msg, CallbackParam param) {
        // 返回JSONP格式
        if(param != null && StringUtils.isNotBlank(param.getCallback())) {
            return returnJSONPString(param, returnJSONString(ApiResult.getFailed(msg), null));
        }

        return returnJSONString(ApiResult.getFailed(msg), null);
    }

    /**
     * 提交参数验证出错结果构造 {@link ApiResult}
     * @param bindingResult 错误绑定对象
     * @param param         提交的请求参数
     * @return
     */
    public static Object getValidFailedResult(BindingResult bindingResult, CallbackParam param) {
        if(bindingResult != null && !bindingResult.hasErrors()){
            throw new RuntimeException(ErrorMessage.INTERNAL_SERVER);
        }
        StringBuilder sb = new StringBuilder(32);
        List<ObjectError> list = bindingResult.getAllErrors();
        list.forEach(error -> sb.append(error.getDefaultMessage()).append(";"));
        if(sb.length() > 0){
            sb.setLength(sb.length() - 1);
        }


        return getFailedResult(sb.toString(), param);
    }
}
