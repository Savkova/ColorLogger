package color_logger;

public class LoggerImpl implements Logger
{
    LoggerImpl()
    {
    }

    @LogColor(value = MyColor.RED)
    @Override
    public void error(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = MyColor.PURPLE)
    @Override
    public void warn(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = MyColor.GREEN)
    @Override
    public void info(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = MyColor.BLUE)
    @Override
    public void debug(String msg)
    {
        System.out.println(msg);
    }

    @LogColor(value = MyColor.CYAN)
    @Override
    public void trace(String msg)
    {
        System.out.println(msg);
    }
}
