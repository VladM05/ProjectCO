package testbench;

import bench.IBenchmark;
import bench.NewtonSquareRoot;
import bench.PopulateArray;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestPopulateArray {
    public static void main(String[] args) {

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        int nr_cores=Runtime.getRuntime().availableProcessors();
        PopulateArray bench = new PopulateArray();

        bench.initialize(Runtime.getRuntime().availableProcessors());
        bench.warmUp();
        timer.start();
        bench.run();
        long time = timer.stop();

        TimeUnit timeUnit = TimeUnit.Sec;
        log.writeTime("Finished in  ", time, timeUnit);
        double score1 = Math.log(10000)*(1000000000.0/Math.log(time));
        System.out.println("Score is "+score1);
    }
}
