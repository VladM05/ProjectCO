package bench;

public class NewtonSquareRoot implements IBenchmark {
    private int threadnr;

    @Override
    public void initialize(Object... params) {
        threadnr=(Integer)params[0];
    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run() {
        Thread t;
        for(int i=0;i<threadnr;i++){
            t=new Thread(new SquareRootRunnable(i,Integer.toString(i)));
            t.start();
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void clean() {

    }
}
