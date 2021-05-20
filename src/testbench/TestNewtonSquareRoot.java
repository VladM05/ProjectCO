package testbench;

import logging.*;
import timing.*;
import bench.*;

public class TestNewtonSquareRoot {
    public TestNewtonSquareRoot(){
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench=new NewtonSquareRoot();
        bench.initialize(Runtime.getRuntime().availableProcessors());
        bench.warmUp();
        timer.start();
        bench.run();
        long time= timer.stop();
        System.out.println("Tested in "+time/Math.pow(10, 9)+" seconds");
    }
}
