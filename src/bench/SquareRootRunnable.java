package bench;

public class SquareRootRunnable implements Runnable{

    private Thread t;
    private int thread;
    private String threadname;
    public SquareRootRunnable(int threadnr,String name){
        thread=threadnr;
        threadname=name;
    }

    @Override
    public void run() {
        double root,expression,tmp;

        int startnr;
        int endnr;
        startnr=(thread*1000000)+1;
        endnr=(thread*1000000)+1000000;
        for (int i = startnr; i <= endnr; i++) {
            root = i;
            expression = (root * root) - i;
            while (Math.abs(expression) > 0.0001) {
                tmp = ((i / root) + root) / 2;
                root = tmp;
                expression = (root * root) - i;
            }
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread (this,threadname);
            t.start ();
        }
    }
}
