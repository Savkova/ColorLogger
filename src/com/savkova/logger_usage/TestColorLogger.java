package com.savkova.logger_usage;

import com.savkova.color_logger.Logger;
import com.savkova.color_logger.LoggerFactory;
import com.savkova.color_logger.LoggerImpl;

public class TestColorLogger
{
    public static void main(String[] args)
    {
        System.out.println("Begin");

        try
        {
            Logger logger = LoggerFactory.create(LoggerImpl.class);

            logger.debug("debug message");
            logger.warn("warn message");
            logger.info("info message");
            logger.trace("trace message");
            logger.error("error message");

        } catch (IllegalAccessException | InstantiationException e)
        {
            e.printStackTrace();
        }

        System.out.println("End");
    }
}
