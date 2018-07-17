package com.company.sortedSet;

import java.util.*;

/**
 * Created by Vladyslava_Hubenko on 7/17/2018.
 */
public class SortedSetApp {

    public static void main(String[] args) {
        NavigableSet<Integer> set = initialize();
//        System.out.println(getNextElem(set.iterator(), 5));
//        System.out.println(getPrevElements(set.iterator(), 5));

        System.out.println(set.lower(5));
        System.out.println(set.higher(5));
        System.out.println(set.headSet(5));
        System.out.println(set.tailSet(5));
        System.out.println(set.descendingSet());

    }

    static NavigableSet<Integer> initialize(){
        NavigableSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < 10; i++){
            set.add(i);
        }
        return set;
    }

    static Integer getNextElem(Iterator iterator, Integer i){
        while (iterator.hasNext()){
            if(iterator.next() == i)
                return (Integer) iterator.next();
        }
        System.out.println("NO next");
        return null;
    }

    static Set<Integer> getPrevElements(Iterator iterator, Integer i){
        Set<Integer> set = new HashSet<>();
        while (iterator.hasNext()){
            Integer el = (Integer) iterator.next();
            if(el == i)
                return set;
            else set.add(el);
        }
        System.out.println("NO prev");
        return null;
    }
}
