package com.company.listsTime;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Vladyslava_Hubenko on 7/18/2018.
 */
public class ListTimeApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Set<Integer> first = new ConcurrentSkipListSet<>();
        List<Integer> second = new CopyOnWriteArrayList<Integer>();

        for (int i = 1; i <= 100; i++){
            first.add(i);
            second.add(i);
        }

        task(first);
        task(second);

        System.out.println("Completed.");
    }

    private static void task(Collection<Integer> list) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1); // coundown from 3 to 0

        ExecutorService executor = Executors.newFixedThreadPool(2); // 3 Threads in pool

        Future<Long> time1 = executor.submit(new MyTask(latch, list, 0));
        Future<Long> time2 = executor.submit(new MyTask(latch, list, 50));

        latch.countDown();

        System.out.println("Time1 = " + time1.get()/1000);
        System.out.println("Time2 = " + time2.get()/1000);
    }

}

class MyTask implements Callable<Long> {

    private CountDownLatch latch;
    Collection<Integer> list;
    int indexStart;

    MyTask(CountDownLatch latch, Collection<Integer> list, int indexStart){
        this.latch = latch;
        this.list = list;
        this.indexStart = indexStart;
    }

    @Override
    public Long call() throws Exception {
        latch.await();
        long time = System.nanoTime();
        int indexEnd = indexStart + 50;
        for (int i = indexStart; i < indexEnd; i++){
            list.contains(i);
        }
        return System.nanoTime() - time;
    }
}
