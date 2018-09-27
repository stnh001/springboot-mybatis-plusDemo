package com.mybatisplus.controller;


import com.mybatisplus.common.CallbackParam;
import com.mybatisplus.common.ErrorMessage;
import com.mybatisplus.common.ResultUtil;
import com.mybatisplus.service.impl.Tbl_employeeServiceDiy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luwan
 * @since 2018-09-26
 */
@Slf4j
@RestController
@RequestMapping("/tbl_employee")
public class Tbl_employeeAction {

    @Autowired
    private Tbl_employeeServiceDiy tbl_employeeServiceDiy;

    @RequestMapping("/list")
    public Object getRealTimeHistoryList(@PathVariable("type") int type, CallbackParam param) {
        if(log.isDebugEnabled()){
            log.debug("tbl_employeelist接受到参数：PathVariable:{}, param:{}", type, param);
        }
        try {
            return tbl_employeeServiceDiy.selectList(null);
        } catch (Exception ex) {
            log.error(String.format("tbl_employeelist接受到参数接受到参数：PathVariable:%s, param:%s", type, param), ex);
            return ResultUtil.getFailedResult(ErrorMessage.INTERNAL_SERVER, param);
        }
    }

}

