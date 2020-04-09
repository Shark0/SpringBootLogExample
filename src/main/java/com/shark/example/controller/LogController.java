package com.shark.example.controller;

import com.shark.example.aop.log.TimeLog;
import com.shark.example.type.LogType;
import com.shark.example.util.log.LogUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/log")
@RestController
public class LogController {

    @TimeLog
    @GetMapping("/time")
    public String time(){
        return "time";
    }

    @GetMapping("/custom")
    public String custom(){
        LogUtil.log(LogType.CUSTOM, Long.valueOf(1), "LogController", "custom", "test custom log");
        return "custom";
    }

    @GetMapping("/error")
    public String error(){
        String response = "error";
        response = response.substring(1000, 2000);
        return response;
    }
}
