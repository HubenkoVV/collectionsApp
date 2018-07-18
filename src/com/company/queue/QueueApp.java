package com.company.queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Vladyslava_Hubenko on 7/18/2018.
 */
public class QueueApp {

    public static void main(String[] args) {
        /*Queue<Integer> queue = new LinkedList<>();
        for (int i = 5; i > 0; i--){
            queue.add(i);
        }
        while (!queue.isEmpty()) System.out.println(queue.poll());

        System.out.println("-----------------");

        Queue<Integer> queue2 = new PriorityQueue<>();
        for (int i = 5; i > 0; i--){
            queue2.add(i);
        }
        while (!queue2.isEmpty()) System.out.println(queue2.poll());*/

        Queue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1%2 == 0 && o2%2 != 0)
                    return -1;
                if(o1%2 != 0 && o2%2 == 0)
                    return 1;
                return o1.compareTo(o2);
            }
        });
        for (int i = 5; i > 0; i--){
            queue2.add(i);
        }
        while (!queue2.isEmpty()) System.out.println(queue2.poll());




    }

}
