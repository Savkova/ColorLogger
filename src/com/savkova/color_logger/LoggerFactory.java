package com.savkova.color_logger;

public class LoggerFactory
{
    public static Logger create(Class<? extends Logger> loggerClass) throws IllegalAccessException, InstantiationException
    {
        return new LoggerWrapper(loggerClass.newInstance());
    }
}
