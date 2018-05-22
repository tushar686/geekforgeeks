package jdk.thread;

import java.util.Objects;

/**
 * Created by ts250370 on 5/4/18.
 */
public class DeadLock {

    class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                synchronized (String.class) {
                    System.out.println("Thread-1 acquires lock on String");
                    Thread.sleep(100);
                    System.out.println("Thread-1 will try to acquire lock on Object");
                    synchronized (Objects.class) {
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                synchronized (Objects.class) {
                    System.out.println("Thread-2 acquires lock on Object");
                    Thread.sleep(100);
                    System.out.println("Thread-2 will try to acquire lock on String");
                    synchronized (String.class) {
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void createDeadlock() {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

//        thread1.interrupt();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.createDeadlock();

    }

}
