package color_logger;

public class LoggerImpl implements Logger
{
    LoggerImpl()
    {
    }

    @LogColor(value = Color.RED)
    @Override
    public void error(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = Color.PURPLE)
    @Override
    public void warn(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = Color.GREEN)
    @Override
    public void info(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = Color.BLUE)
    @Override
    public void debug(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = Color.CYAN)
    @Override
    public void trace(String msg)
    {
        System.out.println(msg);
    }
}
