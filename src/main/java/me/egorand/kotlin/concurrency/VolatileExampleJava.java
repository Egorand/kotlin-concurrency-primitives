package me.egorand.kotlin.concurrency;

public class VolatileExampleJava {

    private volatile boolean running;

    public void start() {
        running = true;
        new Thread(new Runnable() {
            @Override public void run() {
                while (running) {
                    System.out.println("Still running: " + Thread.currentThread());
                }
            }
        }).start();
    }

    public void stop() {
        running = false;
        System.out.println("Stopped: " + Thread.currentThread());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("starting: " + Thread.currentThread());

        final VolatileExampleJava example = new VolatileExampleJava();

        example.start();

        Thread.sleep(100, 100);

        example.stop();

        System.out.println("finishing: " + Thread.currentThread());
    }
}
