package com.example.sync.target.controller;

import com.example.sync.target.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuming
 * @date 2019/5/12
 */
@RestController
@RequestMapping("target")
public class TargetController {

    @Autowired
    private TargetService targetService;

    @PostMapping("/insert")
    public void start(@RequestBody String message) {
        targetService.save(message);
    }
}
