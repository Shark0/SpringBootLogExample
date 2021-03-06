package com.shark.example.controller;

import com.shark.example.aop.log.Log;
import com.shark.example.controller.dio.CustomInput;
import com.shark.example.service.CustomService;
import com.shark.example.type.LogType;
import com.shark.example.util.log.LogUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/log")
@RestController
public class LogController {

    @Log
    @GetMapping("/time")
    public String time(){
        return "time";
    }

    private final CustomService customService;

    @Log
    @PostMapping("/custom")
    public String custom(@RequestBody CustomInput input){
        LogUtil.log(LogType.CUSTOM, this.getClass().getName(), "custom", "test custom log");
        return customService.start(input);
    }

    @GetMapping("/error")
    public String error(){
        String response = "error";
        response = response.substring(1000, 2000);
        return response;
    }
}
