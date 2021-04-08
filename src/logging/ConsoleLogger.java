package logging;

public class ConsoleLogger implements ILogger{
    public void write(String string)
    {
        System.out.println(string);
    }

    public void write(long value)
    {
        System.out.println(value);
    }

    public void write(Object ... values)
    {
        for(Object i: values)
        {
            System.out.println(i+" ");
            System.out.println();
        }
    }

    public void close()
    {}


}
