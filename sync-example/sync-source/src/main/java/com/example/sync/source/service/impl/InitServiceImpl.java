package com.example.sync.source.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.sync.source.common.Message;
import com.example.sync.source.constant.ApiUrl;
import com.example.sync.source.constant.TableEnum;
import com.example.sync.source.entity.User;
import com.example.sync.source.service.InitService;
import com.example.sync.source.service.SyncService;
import com.example.sync.source.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推动数据
 *
 * @author yuming
 * @date 2019/5/12
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private SyncService<User> userSyncService;

    @Override
    public void init() {
        int count = userSyncService.count();
        System.err.println("当前表数据总数为: count = " + count);
        int pageSize = 1000;
        int page = count / pageSize + 1;
        Map<String, Object> params = new HashMap<>(16);
        Message message = new Message();
        for (int i = 1; i <= page; i++) {
            params.put("start", (i - 1) * pageSize);
            params.put("end", i * pageSize);
            List<User> userList = userSyncService.prepare(params);
            message.setTable(TableEnum.USER.getTable());
            message.setData(userList);
            String result = send(message);
            System.out.println("正在推送第" + i + "页数据, result = " + result);
        }
        System.err.println("推送数据结束!");
    }

    @Override
    public String send(Message message) {
        String string = JSON.toJSONString(message);
        return HttpClientUtils.send(ApiUrl.TARGET, string);
    }
}
