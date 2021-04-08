package timing;

public class Timer implements ITimer{
    long start_time;
    long elapsed_time;
    long total_time;
    long resumed_time;
    boolean paused;

    public void start()
    {
        start_time = System.currentTimeMillis();
        total_time = 0;
        elapsed_time = 0;
        resumed_time = 0;
        paused = true;

    }

    public long stop()
    {
       if(paused)
       {
           return total_time;
       }
       else
       {
           elapsed_time = System.currentTimeMillis() - start_time;
           total_time = total_time + elapsed_time;
           paused = false;
           return total_time;
       }
    }

    public long pause()
    {
        if(paused)
        {
            return elapsed_time;
        }
        else
        {
            elapsed_time = System.currentTimeMillis() - start_time;
            paused = false;
            return elapsed_time;
        }


    }

    public void resume()
    {
        if(!paused)
        {
            paused = true;
            start_time = System.currentTimeMillis();
            total_time = total_time+elapsed_time;
        }

    }
}

