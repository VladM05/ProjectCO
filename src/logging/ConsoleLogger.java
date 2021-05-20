package logging;

public class ConsoleLogger implements ILogger {
    public ConsoleLogger() {
    }

    public void write(long l) {
        System.out.println(l);
    }

    public void write(String s) {
        System.out.println(s);
    }

    public void write(Object... objects) {
        String s = "";
        Object[] var3 = objects;
        int var4 = objects.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Object o = var3[var5];
            s = s + " " + o.toString();
        }

        System.out.println(s);
    }

    public void close() {
    }

    public void writeTime(long value, TimeUnit unit) {
        switch(unit) {
            case Nano:
                System.out.println(value + "Nano");
                break;
            case Micro:
                System.out.println((double)value / Math.pow(10.0D, 3.0D) + "Micro");
                break;
            case Milli:
                System.out.println((double)value / Math.pow(10.0D, 6.0D) + "Milli");
                break;
            case Sec:
                System.out.println((double)value / Math.pow(10.0D, 9.0D) + "Sec");
        }

    }

    public void writeTime(String string, long value, TimeUnit unit) {
        switch(unit) {
            case Nano:
                System.out.println(string + " " + value + "Nano");
                break;
            case Micro:
                System.out.println(string + " " + (double)value / Math.pow(10.0D, 3.0D) + "Micro");
                break;
            case Milli:
                System.out.println(string + " " + (double)value / Math.pow(10.0D, 6.0D) + "Milli");
                break;
            case Sec:
                System.out.println(string + " " + (double)value / Math.pow(10.0D, 9.0D) + "Sec");
        }

    }
}