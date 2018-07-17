package com.company.hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Vladyslava_Hubenko on 7/17/2018.
 */
public class HashMapApp {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");
        map.put(2, "two");
        map.put(1, "one");
        System.out.println(map);
    }

}
