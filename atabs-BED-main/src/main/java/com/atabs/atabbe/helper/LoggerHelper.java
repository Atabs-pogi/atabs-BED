package com.atabs.atabbe.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerHelper.class);

    public static void info(String TAG, Object message){
        LOGGER.info(TAG + " - " + message);
    }

}
