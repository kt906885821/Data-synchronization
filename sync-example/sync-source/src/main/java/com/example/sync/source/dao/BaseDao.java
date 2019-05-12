package com.example.sync.source.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Mapper
public interface BaseDao {

    /**
     * 查询总数
     *
     * @return count
     */
    int count();
}
