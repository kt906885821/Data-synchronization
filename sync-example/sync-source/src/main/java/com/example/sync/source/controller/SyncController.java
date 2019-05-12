package com.example.sync.source.controller;

import com.example.sync.source.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuming
 * @date 2019/5/12
 */
@RestController
@RequestMapping("sync")
public class SyncController {

    @Autowired
    private InitService initService;

    @GetMapping("/start")
    public void start() {
        System.out.println("数据同步开始!");
        initService.init();
    }
}
