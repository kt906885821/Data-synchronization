package com.example.sync.source.service;

import com.example.sync.source.common.Message;

/**
 * @author yuming
 * @date 2019/5/12
 */
public interface InitService {

    /**
     * 开始推送数据
     */
    void init();

    /**
     * 发送数据
     *
     * @param message
     * @return
     */
    String send(Message message);
}
