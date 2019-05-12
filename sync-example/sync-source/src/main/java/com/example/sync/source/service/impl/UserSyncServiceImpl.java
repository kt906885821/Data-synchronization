package com.example.sync.source.service.impl;

import com.example.sync.source.dao.UserDAO;
import com.example.sync.source.entity.User;
import com.example.sync.source.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yuming
 * @date 2019/5/12
 */
@Service
public class UserSyncServiceImpl implements SyncService<User> {

    @Autowired
    private UserDAO userDAO;


    @Override
    public int count() {
        return userDAO.count();
    }

    @Override
    public List<User> prepare(Map params) {
        Integer start = (Integer) params.get("start");
        Integer end = (Integer) params.get("end");
        return userDAO.findByPage(start, end);
    }
}
