package com.example.sync.source.constant;

/**
 * 同步相关表
 *
 * @author yuming
 * @date 2019/5/12
 */
public enum TableEnum {
    /** 用户表 */
    USER("SYNC_USER");

    private String table;

    TableEnum(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
