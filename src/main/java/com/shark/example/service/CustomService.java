package com.shark.example.service;

import com.shark.example.controller.dio.CustomInput;
import com.shark.example.type.LogType;
import com.shark.example.util.log.LogUtil;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

@Service
public class CustomService {
    public String start(CustomInput customInput) {
        LogUtil.log(LogType.CUSTOM, this.getClass().getName(), "start", "CustomService Start");
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            LogUtil.log(LogType.ERROR, this.getClass().getName(), "start", stringWriter.toString());
        }
        return customInput.getMessage();
    }
}
