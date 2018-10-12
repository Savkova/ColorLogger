package color_logger;

public enum Color
{
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private static final String ANSI_RESET = "\u001B[0m";
    private final String startCode;

    Color(String startCode)
    {
        this.startCode = startCode;
    }

    public String convert(String text)
    {
        return this.startCode + text + Color.ANSI_RESET;
    }
}
