package bench;

import java.lang.reflect.Array;
import java.util.Random;

public class PopulateArrayRunnable implements Runnable {
    Thread t;
    private String threadname;
    private int start;
    private int array[][];
    private int size;
    public PopulateArrayRunnable(int startpoint,int array[][],int size,String name){
        threadname=name;
        start=startpoint;
        this.array=array;
        this.size=size;
    }

    @Override
    public void run() {
        int endpoint=start+1000;
        int j;
        int upperbound=10000;
        Random rand=new Random();

        for(int i=start;i<endpoint;i++){
            for(j=0;j<size;j++)
                assign(array, rand.nextInt(upperbound),i,j);
        }
    }

    public synchronized void assign(int place[][],int nr,int i,int j){
        place[i][j]=nr;
    }

    public void start () {
        if (t == null) {
            t = new Thread (this,threadname);
            t.start ();
        }
    }

}
