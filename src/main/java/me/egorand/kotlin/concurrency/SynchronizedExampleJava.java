package me.egorand.kotlin.concurrency;

public class SynchronizedExampleJava {

    public synchronized void synchronizedMethod() {
        System.out.println("inside a synchronized method: " + Thread.currentThread());
    }

    public void methodWithSynchronizedBlock() {
        System.out.println("outside of a synchronized block: " + Thread.currentThread());
        synchronized (this) {
            System.out.println("inside a synchronized block: " + Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        System.out.println("starting: " + Thread.currentThread());

        final SynchronizedExampleJava example = new SynchronizedExampleJava();

        new Thread(new Runnable() {
            @Override public void run() {
                example.synchronizedMethod();
            }
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                example.methodWithSynchronizedBlock();
            }
        }).start();

        System.out.println("finishing: " + Thread.currentThread());
    }
}
