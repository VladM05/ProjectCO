package testbench;

import bench.IBenchmark;
import bench.NewtonSquareRoot;
import bench.PopulateArray;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class TestPopulateArray {
    public TestPopulateArray(){
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench=new PopulateArray();
        bench.initialize(Runtime.getRuntime().availableProcessors());
        bench.warmUp();
        timer.start();
        bench.run();
        long time= timer.stop();
        System.out.println("Tested in "+time/Math.pow(10, 9)+" seconds");
    }
}
