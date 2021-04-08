package bench;

public interface IBenchmark {

  public void initialize(Object ... params);

public void warmUp();

public void run();

public void run(Object ... params);

public void cancel();

public void clean();
}