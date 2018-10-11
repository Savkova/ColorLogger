package color_logger;

import java.lang.reflect.Method;

public class LoggerWrapper implements Logger
{
    private Logger loggerImpl;

    private static final String ERROR = "error";
    private static final String WARN = "warn";
    private static final String INFO = "info";
    private static final String DEBUG = "debug";
    private static final String TRACE = "trace";

    LoggerWrapper(Logger loggerImpl)
    {
        this.loggerImpl = loggerImpl;
    }

    @Override
    public void error(String msg)
    {
        MyColor color = inspect(this.loggerImpl.getClass(), ERROR);
        loggerImpl.error(color.convert(msg));
    }

    @Override
    public void warn(String msg)
    {
        MyColor color = inspect(this.loggerImpl.getClass(), WARN);
        loggerImpl.error(color.convert(msg));
    }

    @Override
    public void info(String msg)
    {
        MyColor color = inspect(this.loggerImpl.getClass(), INFO);
        loggerImpl.error(color.convert(msg));
    }

    @Override
    public void debug(String msg)
    {
        MyColor color = inspect(this.loggerImpl.getClass(), DEBUG);
        loggerImpl.error(color.convert(msg));
    }

    @Override
    public void trace(String msg)
    {
        MyColor color = inspect(this.loggerImpl.getClass(), TRACE);
        loggerImpl.error(color.convert(msg));
    }

    private MyColor inspect(Class<? extends Logger> loggerClass, String methodName)
    {
        MyColor color = MyColor.BLACK;
        try
        {
            Method method = loggerClass.getMethod(methodName, String.class);

            if (method.isAnnotationPresent(LogColor.class))
                color = method.getAnnotation(LogColor.class).value();

        } catch (NoSuchMethodException e)
        {
            System.out.println(e.getMessage());
        }

        return color;
    }
}
