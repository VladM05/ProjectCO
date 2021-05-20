package testbench;

import bench.NewtonSquareRoot;
import bench.FFT;
import bench.IBenchmark;
import bench.PopulateArray;
import timing.ITimer;
import timing.Timer;

public class TestBench {

    public long run() {
        ITimer timer = new Timer();

        NewtonSquareRoot squareRoot=new NewtonSquareRoot();
        //IBenchmark tan = new Tan();
        IBenchmark fft = new FFT();
        PopulateArray populateArray=new PopulateArray();

        int fftSize = 1048576;
        long time1, time2, time3, time4;
        int nr_cores=Runtime.getRuntime().availableProcessors();
        timer.start();

        squareRoot.initialize(nr_cores);
        squareRoot.run();
        time1 = timer.pause();

        timer.resume();
        populateArray.warmUp();
        populateArray.run(nr_cores);
        time2 = timer.pause();

        timer.resume();
        fft.initialize(fftSize);
        fft.run();
        time3 = timer.pause();

        double score1 = Math.log(nr_cores*1000000)*(1000000000.0/Math.log(time1));
        double score2 = Math.log(nr_cores*nr_cores*1000000)*(1000000000.0/Math.log(time2));
        double score3 = Math.log(fftSize)*(1000000000.0/Math.log(time3));
        double score = (( score1*0.33 + score2*0.33 + score3*0.34)/3)/20000.0;

        return (long)score;
    }


}