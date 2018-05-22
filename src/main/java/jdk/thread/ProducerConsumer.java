package jdk.thread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ts250370 on 5/5/18.
 */
public class ProducerConsumer {
    List<Integer> sharedQueue = new LinkedList<>();

    class Producer implements Runnable {
        @Override
        public void run() {
            int i = 0;
            try {
                while (true) {
                    synchronized (sharedQueue) {
                        while (sharedQueue.size() > 1) {
                            sharedQueue.wait();
                        }
                        System.out.println("  Produced " + i);
                        sharedQueue.add(i++);

                        Thread.sleep((long) (Math.random() * 500));
                        sharedQueue.notify();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (sharedQueue) {
                        while (sharedQueue.size() == 0) {
                            sharedQueue.wait();
                        }
                        System.out.println("Consumed " + sharedQueue.remove(0));
                        Thread.sleep((long)(Math.random() * 2000));
                        sharedQueue.notify();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void createThread() {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.createThread();
    }
}
