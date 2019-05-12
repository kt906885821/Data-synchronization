package com.example.sync.source.service;

import java.util.List;
import java.util.Map;

/**
 * @author yuming
 * @date 2019/5/12
 */
public interface SyncService<T> {

    /**
     * 查询总数
     * @return
     */
    int count();

    /**
     * 准备数据
     *
     * @param params
     */
    List<T> prepare(Map params);
}
