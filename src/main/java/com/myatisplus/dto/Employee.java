package com.myatisplus.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created by luwan on 2018/9/23.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
}
