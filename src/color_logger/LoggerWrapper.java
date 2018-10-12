package color_logger;

import java.lang.reflect.Method;
import java.util.EnumMap;

public class LoggerWrapper implements Logger
{
    private Logger loggerImpl;
    private EnumMap<MessageType, Color> methodColorsMap = new EnumMap<MessageType, Color>(MessageType.class);


    LoggerWrapper(Logger loggerImpl)
    {
        this.loggerImpl = loggerImpl;
        inspect(this.loggerImpl.getClass());
    }

    @Override
    public void error(String msg)
    {
        loggerImpl.error(methodColorsMap.get(MessageType.error).convert(msg));
    }

    @Override
    public void warn(String msg)
    {
        loggerImpl.error(methodColorsMap.get(MessageType.warn).convert(msg));
    }

    @Override
    public void info(String msg)
    {
        loggerImpl.error(methodColorsMap.get(MessageType.info).convert(msg));
    }

    @Override
    public void debug(String msg)
    {
        loggerImpl.error(methodColorsMap.get(MessageType.debug).convert(msg));
    }

    @Override
    public void trace(String msg)
    {
        loggerImpl.error(methodColorsMap.get(MessageType.trace).convert(msg));
    }

    private void inspect(Class<? extends Logger> loggerClass)
    {
        try
        {
            Method method;
            for (MessageType messageType : MessageType.values())
            {
                method = loggerClass.getMethod(messageType.name(), String.class);

                if (method.isAnnotationPresent(LogColor.class))
                    methodColorsMap.put(messageType, method.getAnnotation(LogColor.class).value());

            }
        } catch (NoSuchMethodException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
