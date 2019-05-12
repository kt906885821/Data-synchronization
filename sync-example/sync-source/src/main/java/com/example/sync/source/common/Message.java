package com.example.sync.source.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = -2955971990309818552L;

    private String table;

    private Object data;
}
