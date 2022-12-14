package com.example.neoflex.web.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;

public final class ExceptionHandleUtils {

    private ExceptionHandleUtils(){}
    public static String buildErrorMessage(Throwable t) {
        StringBuilder message = new StringBuilder(ExceptionUtils.getMessage(t));

        Throwable cause;
        if((cause = t.getCause()) != null){
            message.append(", cause: ").append(ExceptionUtils.getMessage(cause));
        }

        return message.toString();
    }
}
