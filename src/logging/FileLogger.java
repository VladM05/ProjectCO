package logging;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {
    FileWriter file_log;

    public FileLogger(String file_name)
    {
        try
        {
         file_log = new FileWriter(file_name);
        } catch (IOException e)
            {
                 System.out.println("Error!");
                 e.printStackTrace();
            }
    }

    public void write(long param)
    {
        try
        {
            file_log.write(String.valueOf(param));
        } catch (IOException e)
            {
                System.out.println("Error!");
                e.printStackTrace();
            }

    }

    public void write(String param)
    {
        try
        {
            file_log.write(param);
        } catch (IOException e)
        {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public void write(Object ... value)
    {
        try
        {
            for(Object i: value)
            {
                file_log.write(i.toString());
                file_log.write(" ");
            }
        } catch (IOException e)
        {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            file_log.close();
        } catch (IOException e)
            {
                System.out.println("Error!");
                e.printStackTrace();
            }
    }

}
