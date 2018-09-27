package com.mybatisplus.service.impl;

import com.mybatisplus.entity.Tbl_employee;
import com.mybatisplus.mapper.Tbl_employeeDao;
import com.mybatisplus.service.MPTbl_employeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luwan
 * @since 2018-09-26
 */
@Service
public class Tbl_employeeServiceDiy extends ServiceImpl<Tbl_employeeDao, Tbl_employee> implements MPTbl_employeeService {

}
