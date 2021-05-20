package testbench;

import timing.*;
import logging.*;
import bench.*;

public class TestFFT {
	public static void main(String args[]) {
		ITimer timer = new Timer();
		ILogger log = new ConsoleLogger();
		FFT bench = new FFT();
		
		bench.initialize(1048576);
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