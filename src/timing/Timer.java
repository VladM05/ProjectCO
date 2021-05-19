package timing;

public class Timer implements ITimer{
    long time;
    long total_time;
    long elapsed_time;

    @Override
    public void start()
    {
        time = System.nanoTime();
        total_time = 0;

    }

    @Override
    public long stop()
    {

        elapsed_time = System.nanoTime() - time;
        total_time = total_time + elapsed_time;
        return total_time;

    }

    @Override
    public long pause()
    {

        long pause_time = System.nanoTime() - time;
        total_time = total_time + pause_time;
        return pause_time;

    }

    @Override
    public void resume()
    {
        time= System.nanoTime();

    }
}

