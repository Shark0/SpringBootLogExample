package com.shark.example.util.log;

import com.shark.example.type.LogType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

    public static void log(LogType logType, Long userId, String className, String mehtodName, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(userId).append("\t").append(className).append("\t")
                .append(mehtodName).append("\t").append(message.replace(" ", "_"));
        String logMessage = stringBuilder.toString();
        System.out.println(logMessage);
        switch (logType) {
            case TIME:
                log.trace(logMessage);
                break;
            case CUSTOM:
                log.info(logMessage);
                break;
            case ERROR:
                log.warn(logMessage);
                break;
        }
    }
}
