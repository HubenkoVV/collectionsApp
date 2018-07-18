package com.company.synhQueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Vladyslava_Hubenko on 7/18/2018.
 */

public class SynhQueueApp {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        new Producer(queue).start();
        new Consumer(queue).start();
    }

}

class Producer extends Thread{

    private SynchronousQueue<Integer> queue;

    public Producer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i<3; i++) {
                Thread.sleep(3000);
                System.out.println("Put into queue");
                queue.put(new Random().nextInt(100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread{

    private SynchronousQueue<Integer> queue;

    public Consumer(SynchronousQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i<3; i++) {
                int el = queue.take();
                System.out.println("Take " + el);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
