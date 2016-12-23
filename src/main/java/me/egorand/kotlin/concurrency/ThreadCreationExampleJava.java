package me.egorand.kotlin.concurrency;

public class ThreadCreationExampleJava {

    public static void main(String[] args) {
        System.out.println("starting: " + Thread.currentThread());

        // subclassing Thread class to create a new thread
        new Thread() {
            @Override public void run() {
                System.out.println("running from Thread: " + Thread.currentThread());
            }
        }.start();

        // passing a Runnable to create a thread
        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("running from Runnable: " + Thread.currentThread());
            }
        }).start();

        System.out.println("finishing: " + Thread.currentThread());
    }
}
