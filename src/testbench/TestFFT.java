package testbench;

import timing.*;
import logging.*;
import bench.*;

public class TestFFT {
	public static void main(String args[]) {
		ITimer timer = new Timer();
		ILogger log = new ConsoleLogger();
		IBenchmark bench = new FFT();
		
		bench.initialize(1048576);
		timer.start();
		bench.run();
		long time = timer.stop();
		
		TimeUnit timeUnit = TimeUnit.Sec;
		log.writeTime("Finished in ", time, timeUnit);
	}
}