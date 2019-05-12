package com.example.sync.target.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.sync.target.constant.TableEnum;
import com.example.sync.target.dao.UserDAO;
import com.example.sync.target.entity.User;
import com.example.sync.target.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Service
public class TargetServiceImpl implements TargetService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        String table = (String) jsonObject.get("table");
        if (TableEnum.USER.getTable().equals(table)) {
            List<User> userList = (List<User>) jsonObject.get("data");
            int row = userDAO.batchInsert(userList);
            System.out.println("新增同步数据: row = " + row);
        }
    }
}
