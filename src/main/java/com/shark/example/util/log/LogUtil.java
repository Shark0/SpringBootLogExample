package com.shark.example.util.log;

import com.shark.example.type.LogType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtil {

    public static void log(LogType logType, String className, String methodName, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(className).append("\t")
                .append(methodName).append("\t").append(message);
        String logMessage = stringBuilder.toString();
        System.out.println(logMessage);
        switch (logType) {
            case TIME:
                log.trace(logMessage);
                break;
            case CUSTOM:
                log.info(logMessage);
                break;
            case ACCESS:
                log.warn(logMessage);
                break;
            case ERROR:
                log.error(logMessage);
                break;
        }
    }
}
