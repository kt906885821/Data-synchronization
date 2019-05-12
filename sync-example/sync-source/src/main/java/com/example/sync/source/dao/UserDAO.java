package com.example.sync.source.dao;

import com.example.sync.source.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Mapper
public interface UserDAO extends BaseDao {

    /**
     * 分页查询
     *
     * @param start 起始位置
     * @param end   结束位置
     * @return list
     */
    List<User> findByPage(@Param("start") Integer start, @Param("end") Integer end);
}