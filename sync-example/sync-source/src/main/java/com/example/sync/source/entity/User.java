package com.example.sync.source.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private BigDecimal id;

    /** 姓名 */
    private String userName;

    /** 年龄 */
    private BigDecimal userAge;

}