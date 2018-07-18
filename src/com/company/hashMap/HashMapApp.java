package com.company.hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Vladyslava_Hubenko on 7/17/2018.
 */
public class HashMapApp {

    public static void main(String[] args) {
        /*LinkedHashMap<Integer, String> map = new LRUCache<>(2);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.get(2);
        map.put(9, "nine");
        System.out.println(map);*/

        Map<Data, String> map = new WeakHashMap<>();
        Data data = new Data();
        map.put(data, "info");

        data = null;
        System.gc();

        for (int i = 1; i< 10_000; i++){
            if(map.isEmpty()) {
                System.out.println("Empty map " + i);
                break;
            }
        }

    }

}
